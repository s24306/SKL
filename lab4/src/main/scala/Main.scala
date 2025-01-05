@main
def Zad1: Unit = {
  val seq = Seq(1, 2, 3, 4, 5, 6, 7)
  println(subSeq(seq, 1, 3))
}

@main
def Zad2: Unit = {
  val seq = Seq(1, 2, 3, 4, 5, 6, 7)
  println(remElems(seq, 2))
}

@main
def Zad3: Unit = {
  val seq = Seq(1, 2, 3)
  val seq2 = Seq(2, 2, 1, 3)
  println(diff(seq, seq2))
}

@main
def Zad4: Unit = {
  val seq = Seq(Some(5.4), Some(-2.0), Some(1.0), None, Some(2.6))
  println(sumOption(seq))
}

@main
def Zad5: Unit = {
  val seq = Seq(1, 1, 2, 4, 4, 4, 1, 3)
  println(deStutter(seq))
}

@main
def Zad6: Unit = {
  val seq = Seq(1, 2, 2, 4)
  val leq = (a: Int, b: Int) => (a <= b)
  println(isOrdered(seq)(leq))
}

@main
def Zad7: Unit = {
  val seq = Seq('a','b','a','c','c','a')
  println(freq(seq))
}

@main
def Zad8: Unit = {
  val seq: Seq[(String, Double)] = Seq(("Dawid", 900), ("Jakub", 300), ("Agata", 2), ("Jezus", 999999), ("Malcolm", 2137), ("Adam", 800))
  println(median(seq))
}

@main
def Zad9: Unit = {
  val seq: Seq[(String, Double)] = Seq(("Dawid", 900), ("Jakub", 300), ("Agata", 2), ("Jezus", 999999), ("Malcolm", 2137), ("Adam", 800))
  println(minMax(seq))
}

@main
def Zad10: Unit = {
  val num: Int = 10
  println(threeNumbers(num))
}

def subSeq[A](seq: Seq[A], begIdx: Int, endIdx: Int): Seq[A] = {
  seq.drop(begIdx).take(endIdx - begIdx + 1)
}

def remElems[A](seq: Seq[A], k: Int): Seq[A] = {
  seq.zipWithIndex.filter{case (_, index) => index != k-1}.map{case (key, index) => key}
  //or seq.filter(_ != seq(k-1))
}

def diff[A](seq1: Seq[A], seq2: Seq[A]): Seq[A] = {
  seq1.zip(seq2).filter{ case (a, b) => a != b}.map{ case (a, b) => a}
}

def sumOption(seq: Seq[Option[Double]]): Double = {
  seq.foldLeft(0.0){ (acc, el) => 
    el match{ 
      case Some(el) => acc + el
      case None => acc
    }
  }
}

def deStutter[A](seq: Seq[A]): Seq[A] = {
  seq.foldLeft(Seq[A]()){ (acc, num) =>
    num match {
      case a if(acc.isEmpty || acc.last !=num) => acc :+ num
      case _ => acc
    }
  }
}

def isOrdered[A](seq: Seq[A])(leq:(A, A) => Boolean): Boolean = {
  seq.sliding(2).forall {
    case Seq(a, b) => leq(a, b)
    case _ => true
  }
}

def freq[A](seq: Seq[A]): Set[(A, Int)] = {
  seq.groupBy(identity).map{ case (key, value) => (key, value.size)}.toSet
}

def median(seq: Seq[(String, Double)]): Double = {
  val a = seq.sortBy(_._2).map(_._2)
  a.length %2 == 0 match{
    case true => (a.apply(a.length/2) + a.apply(a.length/2 - 1)) / 2
    case false => a.apply(a.length/2)
  }
}

def minMax(seq: Seq[(String, Double)]): Option[(String, String)] = {
  val min = seq.minBy(_._2)._1
  val max = seq.maxBy(_._2)._1
  Some(min, max)
}

def threeNumbers(n: Int): Set[(Int, Int, Int)] = {
  (for {
    a <- 1 to n
    b <- a + 1 to n
    c <- b + 1 to n
    if a*a + b*b == c*c
  } yield (a, b, c)).toSet
}