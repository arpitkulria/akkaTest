package com

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Person(val name: String) {
    def say() = {
      new VoiceOf(this)
    }
  }
  class VoiceOf(obj: Person) {
    def hi() = { println("hi") }

    def hi(o: Person) = {
      println(o.name)
    }

    def yourName() = {

      println(obj.name)
    }

  }

  val ob = new Person("Arpit")                    //> ob  : com.test.Person = com.test$$anonfun$main$1$Person$1@5bc8e35a
  val obPerson = new Person("Nikhil")             //> obPerson  : com.test.Person = com.test$$anonfun$main$1$Person$1@61c658c9
  val ob1 = new VoiceOf(ob)                       //> ob1  : com.test.VoiceOf = com.test$$anonfun$main$1$VoiceOf$1@50b98ef4
  ob1.yourName()                                  //> Arpit
  ob1.hi()                                        //> hi
  ob1.hi(ob)                                      //> Arpit
  ob1.hi(obPerson)                                //> Nikhil
  
  val lst=List(1,2,3,4,5)                         //> lst  : List[Int] = List(1, 2, 3, 4, 5)
  
  
}