import scala.math._

@main
def mainProg: Unit = {
  val num: C = new C(1, 1)
  val num2: C = new C(3, 2)
  print(num < num2)
}

class C(val re: Double, val im: Double) extends Ordered[C] {

  val modulus: Double = sqrt(this.re * this.re + this.im * this.im)

  def this(re: Double) = this(re, im = 0.0)

  override def toString(): String = {
    if(im > 0){
      return re + " + " + im + "i\n"
    } else if (im < 0){
      return re + " - " + im.abs + "i\n"
    } else {
      return re + "\n"
    }
  }

  def compare(that: C): Int = {
    if(this.modulus == that.modulus){
      0
    } else if (this.modulus > that.modulus){
      1
    } else if (this.modulus >= that.modulus){
      1
    } else if (this.modulus < that.modulus){
      -1
    } else if (this.modulus <= that.modulus){
      1
    } else {
      1
    }
  }

  def +(that: C): C = {
    new C(re + that.re, im + that.im)
  }
  def +(that: Int): C = {
    new C(re + that, im)
  }

  def -(that: C): C = {
    new C(re - that.re, im - that.im)
  }
  def -(that: Int): C = {
    new C(re - that, im)
  }

  def *(that: C): C = {
    new C(re * that.re - im * that.im, im * that.re + re * that.im)
  }
  def *(that: Int): C = {
    new C(re * that, im * that)
  }

  def /(that: C): C = {
    val realPart: Double = re * that.re + im * that.im
    val imaginaryPart: Double = im * that.re - re * that.im
    val denominator: Double = that.re * that.re + that.im * that.im
    require(denominator != 0)
    new C(realPart / denominator, imaginaryPart / denominator)
  }
  def /(that: Int): C = {
    require(that != 0)
    new C(re/that, im/that)
  }
}