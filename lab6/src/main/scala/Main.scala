import org.apache.pekko
import pekko.actor.{ActorSystem, Actor, ActorLogging, ActorRef, Props}

class Player extends Actor {
  def receive: Receive = {
    case "Ping" =>
      println("Pong")
      println(self.path.name)
      val next = (self.path.name.stripPrefix("player").toInt % 4) + 1
      Thread.sleep(2000)
      context.actorSelection(s"pekko://Pingpong/user/player${next}") ! "Pong"

    case "Pong" =>
      println("Ping")
      println(self.path.name)
      val next = (self.path.name.stripPrefix("player").toInt % 4) + 1
      Thread.sleep(2000)
      context.actorSelection(s"pekko://Pingpong/user/player${next}") ! "Ping"
  }
}

@main
def Zad1: Unit = {
  val system = ActorSystem("Pingpong")
  val player1 = system.actorOf(Props[Player](), "player1")
  val player2 = system.actorOf(Props[Player](), "player2")
  val player3 = system.actorOf(Props[Player](), "player3")
  val player4 = system.actorOf(Props[Player](), "player4")

  val players= List("player1", "player2", "player3", "player4")

  player1.tell("Ping", player2)
  
}

case class Init(n: Int)
case class Zlecenie(list: List[String])
case class Policz(str: String)
case class Wynik(n: Int)

class Nadzorca extends Actor {
  def receive: Receive = {
    case Init(n) =>
      val workers = for {
        i <- (1 to n)
      } yield context.actorOf(Props[Pracownik](), s"worker${i}")
      context.become(withWorker(workers.toList))
  }
  def withWorker(workers: List[ActorRef]): Receive = {
    case Zlecenie(str) =>
      val wokrWithTekst = str.zip(workers)
      wokrWithTekst.foreach({
        case (s, w) => w ! Policz(s)
      })
      context.become(counting(0, workers.toSet, str.drop(wokrWithTekst.size)))
  }
  def counting(result: Int, workers: Set[ActorRef], text: List[String]): Receive = {
    case Wynik(n) =>
      if(text.size > 0) {
        context.become(counting(result+n, workers, text.tail))
        sender() ! Policz(text.head)
      }
      else if(workers.size > 1){
        context.become(counting(result+n, workers-sender(), text))
      }
      else {
        println(s"Wyniki ${result}")
        context.become(withWorker(workers.toList))
      }
  }
}

class Pracownik extends Actor {
  def receive: Receive = {
    case Policz(str) =>
      sender() ! Wynik(str.split(" ").size)
  }
}

@main 
def zad2: Unit = {

  def dane(): List[String] = {
   scala.io.Source.fromResource("ogniem_i_mieczem.txt").getLines.toList
  }
  val system = ActorSystem("WordCounter")
  val nadzorca = system.actorOf(Props[Nadzorca](), "Nadzorca")
  nadzorca ! Init(100)
  nadzorca ! Zlecenie(dane())

  println(dane())
}