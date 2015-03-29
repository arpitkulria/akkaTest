package com.wordcount
import akka.actor.{ ActorSystem, ActorLogging, Actor, Props }
import scala.io.Source
import akka.actor.ActorRef

case class OneLineFromFile(line: String, nol: Int)
case class UseOnThePlaceOfMessage(arrayOfWords: Array[String], nol: Int)
case class ClassUsedInParent(wc: Int, nol: Int)

class Parent(child: ActorRef) extends Actor with ActorLogging {

  var wordcount = 0
  var ans = 0
  def receive = {
    case OneLineFromFile(line, nol) =>
      {
        val words = line.split(" ")
        child ! UseOnThePlaceOfMessage(words, nol)

      }
    case ClassUsedInParent(op, nol) => {
      ans += 1
      if (ans == nol) { println(op) }
    }
  }
}

class Child extends Actor with ActorLogging {
  var wordcount = 0
  def receive = {
    case UseOnThePlaceOfMessage(words, nol) =>
      wordcount = wordcount + words.size
      sender ! ClassUsedInParent(wordcount, nol)

  }
}

object WordCountAkka extends App {
  val system = ActorSystem("test")
  val child = system.actorOf(Props[Child], "child")
  val parent = system.actorOf(Props(new Parent(child)), "parent")
  val file = "test.txt"
  //println(Source.fromFile(file).getLines.size)
  val lines = Source.fromFile(file).getLines
  val noOfLines = lines.size
  for (line <- Source.fromFile(file).getLines) {

    parent ! OneLineFromFile(line, noOfLines)
  }
  system.shutdown
}