package com.actorTest

import akka.actor._
import akka.pattern._
import scala.io.Source
import akka.actor.ActorRef
import scala.concurrent.Await
import akka.util.Timeout

case class msgTest(msg: String)

class ParentAkka(ChildAkka: ActorRef) extends Actor with ActorLogging {
  def receive = {
    case msgTest(msgString) => {
      println(msgString)
      val newMsg = msgString + " reply"
      sender ! "Reply from parent"
      ChildAkka ! msgTest(newMsg)

    }
  }
}

class ChildAkka extends Actor with ActorLogging {
  def receive = {
    case msgTest(msgString) => {
      println(msgString)
      sender ! "reply from child"
    }
  }
}
object ActorTest extends App {
  implicit val timeoutcustom = Timeout(5000)
  val system = ActorSystem("test")
  val child = system.actorOf(Props[ChildAkka], "child")
  val parent = system.actorOf(Props(new ParentAkka(child)), "parent")
  val op = parent ? msgTest("hello")
  println((Await.result(op, timeoutcustom.duration)).toString())

  system.shutdown
}