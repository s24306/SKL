import scala.annotation.tailrec

@main
def Zad1: Unit = {
  val lista: List[Int] = List(1, 3, 5, 6, 7)
  println(divide(lista))
}

@main
def Zad2: Unit = {
  val lista: List[Int] = List(1, 3, 5, 7)
  val lista2: List[Int] = List(2, 4, 6, 8, 15, 17)
  val leq = (a: Int, b: Int) => a <= b
  println(merge(lista, lista2)(leq))
}

@main
def Zad3: Unit = {
  val lista: List[Int] = List('a','a','b','c','c','c','d','d','c')
  println(compress(lista))
}

@main
def Zad4: Unit = {
  val lista = List('a', 'b', 'c')
  val lista2 = List('b', 'o', 'c', 'i', 'a', 'n')
  println(isSub(lista2, lista))
}

@main
def Zad5: Unit = {
  val l = List(Some(1), None, Some(2), None, Some(3), Some(4))
  val op1 = (a: Int) => (a + 0)
  val op2 = (a: Int, b: Int) => (a + b)
  println(compute(l)(op1)(op2))
}

@main
def Zad6: Unit = {
  type MSet[A] = A => Int

  val set1: MSet[Int] = (n: Int) => n match {
    case 1 => 2
    case 3 => 1
    case _ => 0
  }

  val set2: MSet[Int] = (n: Int) => n match {
    case 1 => 2
    case 3 => 1
    case _ => 0
  }

  val result = sum(set1, set2)
  println(result(3))
}


def divide[A](list: List[A]): (List[A], List[A]) = {

  @tailrec
  def divideTailrec(list: List[A], even: List[A], odd: List[A]): (List[A], List[A]) = 
    list match {
    case Nil => (even.reverse, odd.reverse)
    case x :: xs => 
      divideTailrec(xs, odd, x :: even)
  }
  
  divideTailrec(list, List.empty, List.empty)
}

def merge[A](a: List[A], b: List[A])(leq: (A, A) => Boolean): List[A] = {

  @tailrec
  def mergeTailrec(a: List[A], b: List[A], c: List[A]): List[A] = (a,b) match {
      case (Nil, Nil) => c.reverse
      case (_, Nil) => c.reverse ++ a
      case (Nil, _) => c.reverse ++ b
      case (first :: aa, second :: bb) =>
      if (leq(first, second)) mergeTailrec(aa, b, first :: c)
      else mergeTailrec(a, bb, second :: c)
  }
  mergeTailrec(a, b, List.empty)
}

def compress[A](list: List[A]): List[(A, Int)] = {

  @tailrec
  def compressTailrec(a: List[A], comp: List[(A, Int)], letter: A, acc: Int): List[(A, Int)] = 
    a match {
      case Nil => ((letter, acc) :: comp).reverse
      case head :: next => 
        head match {
          case b if(head == letter) => compressTailrec(next, comp, letter, acc + 1)
          case _ => compressTailrec(next, (letter, acc) :: comp, head, 1)
        }
  }

  list match {
    case head :: next => compressTailrec(next, List.empty, head, 1)
  }

}

def isSub[A](l: List[A], lSub: List[A]): Boolean = {

  @tailrec
  def isSubTailrec[A](l: List[A], lSub: List[A], lcounter: Int, lsubcounter: Int): Boolean = 
    l match{
      case a if(lcounter >= l.size) => false
      case b if(lsubcounter >= lSub.size) => true
      case c if (l(lcounter) == lSub(lsubcounter)) => isSubTailrec(l, lSub, 0, lsubcounter+1)
      case _ => isSubTailrec(l, lSub, lcounter+1, lsubcounter)
  }
  isSubTailrec(l, lSub, 0, 0)
}

def compute[A, B](l: List[Option[A]])(op1: A => B)(op2: (A, B) => B): Option[B] = {

  @tailrec
  def computeTailrec(l: List[Option[A]], acc: Option[B]): Option[B] = 
    l match{
      case Nil => acc
      case Some(head) :: next => 
        acc match {
          case None => computeTailrec(next, Some(op1(head)))
          case Some(acc) => computeTailrec(next, Some(op2(head, acc)))
        }
      case None :: next => computeTailrec(next, acc)
  }
  computeTailrec(l, None)
}

def compose[A, B, C](f: A => B)(g: B => C): A => C =
  (a: A) => g(f(a))

def prod[A, B, C, D](f: A => C, g: B => D): (A, B) => (C, D) =
  (a: A, b: B) => (f(a), g(b))

def lift[A, B, T](op: (T,T) => T)(f: A => T, g: B => T): (A,B) => T =
  (a: A, b: B) => op(f(a), g(b))

type MSet[A] = A => Int
def sum[A](s1: MSet[A], s2: MSet[A]): MSet[A] = 
  (a: A) => s1(a) + s2(a)

def diff[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
  (a: A) => s1(a) - s2(a)

def mult[A](s1: MSet[A], s2: MSet[A]): MSet[A] =
  (a: A) => s1(a) * s2(a)