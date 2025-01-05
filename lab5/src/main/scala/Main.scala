@main
def Zad1: Unit = {
  println(countChars("cabbac"))
}

@main
def Zad2: Unit = {
  val seq = Seq(1, 2, 3, 4, 5)
  println(swap(seq))
}

@main
def Zad3: Unit = {
  val code = Seq(1, 3, 2, 2, 4, 5)
  val move = Seq(2, 1, 2, 4, 7, 2)
  println(score(code)(move))
}

@main
def zad4: Unit = {
 val linie = io.Source
  .fromResource("ogniem-i-mieczem.txt")
  .getLines.toList.mkString
  
 def histogram(maks: Int): String = {
  val freq = linie
  .filter(_.isLetter)
  .toLowerCase()
  .groupBy(identity)
  .map{ case (key, value) => (key, value.size)}
  .toSet

  val sortedSet = freq.toList.sorted

  val converter = freq.maxBy(_._2)._2 / maks

  val string= { 
    val pairs = for {
      (letter, occurences) <- sortedSet
    } yield (letter, occurences)

    pairs.map{ case (letter, occurences) => 
      f"$letter:${"*" * (occurences/converter)}"
    }.mkString("\n")
  }
  string
 }
 println(histogram(50))
}

@main
def zad5: Unit = {
 case class Województwo(nazwa: String, min: Int)
 // max ID gminy z województwa w: w.min + 19999
 case class Wynik(
  ID: Int,
  KOALICJA_OBYWATELSKA: Int,
  LEWICA_RAZEM: Int,
  POLEXIT: Int,
  JEDNOŚĆ_NARODU: Int,
  PIS: Int,
  EUROPA_CHRISTI: Int,
  WIOSNA: Int,
  KONFEDERACJA: Int,
  KUKIZ15: Int,
  POLSKA_FAIR_PLAY: Int
 )

 val województwa = List(
  Województwo("dolnośląskie",20000),
  Województwo("kujawsko-pomorskie",40000),
  Województwo("lubelskie",60000),
  Województwo("lubuskie",80000),
  Województwo("łódzkie",100000),
  Województwo("małopolskie",120000),
  Województwo("mazowieckie",140000),
  Województwo("opolskie",160000),
  Województwo("podkarpackie",180000),
  Województwo("podlaskie",200000),
  Województwo("pomorskie",220000),
  Województwo("śląskie",240000),
  Województwo("świętokrzyskie",260000),
  Województwo("warmińsko-mazurskie",280000),
  Województwo("wielkopolskie",300000),
  Województwo("zachodniopomorskie",320000)
)

  val wyniki = io.Source
    .fromResource("wyniki.csv")
    .getLines
    .toList
    .map(l => {
      l.split(",").toList.map(_.toInt) match {
      case List(a,b,c,d,e,f,g,h,i,j,k) => Wynik(a,b,c,d,e,f,g,h,i,j,k)
      case _ => throw new IllegalArgumentException
      }
    })

  def calcDiff(wynik: Wynik): Double = {
    val koalicja = wynik.KOALICJA_OBYWATELSKA.toDouble / (wynik.KOALICJA_OBYWATELSKA + wynik.PIS) * 100
    val pis = wynik.PIS.toDouble / (wynik.KOALICJA_OBYWATELSKA + wynik.PIS) * 100
    Math.abs(koalicja - pis)
  }

  val zsumowaneWojewództwa = województwa.map { woj =>
    val wynikiWojewództwa = wyniki.filter(wynik =>
      wynik.ID >= woj.min && wynik.ID <= woj.min + 19999
    )

    val sumaWojewództwa = wynikiWojewództwa.reduce((w1, w2) =>
      Wynik(
        ID = w1.ID,
        KOALICJA_OBYWATELSKA = w1.KOALICJA_OBYWATELSKA + w2.KOALICJA_OBYWATELSKA,
        LEWICA_RAZEM = w1.LEWICA_RAZEM + w2.LEWICA_RAZEM,
        POLEXIT = w1.POLEXIT + w2.POLEXIT,
        JEDNOŚĆ_NARODU = w1.JEDNOŚĆ_NARODU + w2.JEDNOŚĆ_NARODU,
        PIS = w1.PIS + w2.PIS,
        EUROPA_CHRISTI = w1.EUROPA_CHRISTI + w2.EUROPA_CHRISTI,
        WIOSNA = w1.WIOSNA + w2.WIOSNA,
        KONFEDERACJA = w1.KONFEDERACJA + w2.KONFEDERACJA,
        KUKIZ15 = w1.KUKIZ15 + w2.KUKIZ15,
        POLSKA_FAIR_PLAY = w1.POLSKA_FAIR_PLAY + w2.POLSKA_FAIR_PLAY
      )
    )

    (woj.nazwa, calcDiff(sumaWojewództwa))
  }

  val minimalnaRoznica = zsumowaneWojewództwa.minBy(_._2)

  println(
    f"Województwo: ${minimalnaRoznica._1}, różnica: ${minimalnaRoznica._2}%.2f%%"
  )
}

def countChars(str: String): Int = {
  str.toSeq.groupBy(identity).map { case (letter, occurences) => (letter, occurences.size)}.size
}

def swap[A](seq: Seq[A]): Seq[A] = {
  seq.grouped(2).flatMap {
    case Seq(a, b) => Seq(b, a)
    case Seq(a) => Seq(a)
  }.toSeq
}

def score(code: Seq[Int])(move: Seq[Int]): (Int, Int) = {
  val zipped = code.zip(move)
  val black = (for{
    (a, b) <- zipped
    if a == b
  } yield true).size

  val withoutBlack = zipped.filter((a, b) => a != b).toSeq

  val (seq1: Seq[Int], seq2: Seq[Int]) = {
    val pairs = for {
    (a, b) <- withoutBlack
  } yield (a, b)

  val seq1 = pairs.map(_._1)
  val seq2 = pairs.map(_._2)

  (seq1, seq2)
  }

  val whites = seq1.foldLeft(seq2, 0) {
    case ((remainders, hits), current) => 
      remainders.contains(current) match {
        case true => (remainders.patch(remainders.indexOf(current), Nil, 1), hits + 1)
        case false => (remainders, hits)
      }
  }._2
  (black, whites)
}