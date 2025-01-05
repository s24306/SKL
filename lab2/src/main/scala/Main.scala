import scala.annotation.tailrec

@main
def Zad1: Unit = {
  val string: String = scala.io.StdIn.readLine()
  println(reverseString(string))
}

@main
def Zad2: Unit = {
  val num: Int = scala.io.StdIn.readInt()
  println(isPrime(num))
}

@main
def Zad3: Unit = {
  val bin: Int = scala.io.StdIn.readInt()
  println(binToDec(bin))
}

@main
def Zad4: Unit = {
  val num: Int = scala.io.StdIn.readInt()
  println(value(num))
}

@main
def Zad5: Unit = {
  val arr = Array(5, 5, 3, 2, 1)
  println(isOrdered(arr, (a: Int, b: Int) => a >= b))
}

@main
def Zad6: Unit = {
  val arr = Array(5, 5, 3, 2, 1)
  val arr2 = Array(1, 2, 3, 4, 5)
  val pred = (a: Int, b: Int) => a < b
  val op = (a: Int, b: Int) => a - b
  println(worth(arr, arr2)(pred)(op))
}

def reverseString (str: String): String = {
  @tailrec
  def reverse(string: String, reversed: String = ""): String = {
    
    string match {
      case a if string.length == 1 => string.head + reversed
      case _ => reverse(string.tail, string.head + reversed)
    }
  }
  reverse(str)
}

def isPrime(n: Int): Boolean = {

  @tailrec
  def checkPrime(n: Int, i: Int = 2): Boolean = {
    if (n <= 2){
      if (n == 2){
        true
      } else {
        false
      }
    } else if (n % i == 0){
      false
    } else if (i * i > n){
      true
    } else {
      checkPrime(n, i+1)
    }
  }
  checkPrime(n)
}

def binToDec(bin: Int): Int = {

  @tailrec
  def convert(bin: Int, times: Int = 1, acc: Int = 0): Int = {
    if (bin <= 1){
      return acc + bin * times
    }
    convert(bin/10, times*2, acc + (bin%10*times))
  }

  convert(bin)
}

def value(n: Int): Int = {

  @tailrec
  def value(n: Int, f1: Int = 2, f2: Int = 1, counter: Int = 3): Int = {
    if (n == counter){
      f1+f2
    } else {
      value(n, f2, f1+f2, counter + 1)
    }
  }

  value(n)
}

def isOrdered(tab: Array[Int], mlr: (Int, Int) => Boolean): Boolean = {

  @tailrec
  def check(i: Int): Boolean = {
    if (i == tab.length - 1){
      true
    } else if (mlr(tab(i), tab(i+1))){
      check(i+1)
    } else {
      false
    }
  }
  check(0)
}

def worth(tab1: Array[Int], tab2: Array[Int])(pred: (Int, Int) => Boolean)(op: (Int, Int) => Int): Option[Int] = {

  @tailrec
  def find(i: Int): Option[Int] = {
    if(i > tab1.length){
      None
    } else if (pred(tab1(i), tab2(i))){
      Some(op(tab1(i), tab2(i)))
    } else {
      find(i+1)
    }
  }
  find(0)
}