package com

object test {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(70); 
  println("Welcome to the Scala worksheet")

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

  };$skip(299); 

  val ob = new Person("Arpit");System.out.println("""ob  : com.test.Person = """ + $show(ob ));$skip(38); 
  val obPerson = new Person("Nikhil");System.out.println("""obPerson  : com.test.Person = """ + $show(obPerson ));$skip(28); 
  val ob1 = new VoiceOf(ob);System.out.println("""ob1  : com.test.VoiceOf = """ + $show(ob1 ));$skip(17); 
  ob1.yourName();$skip(11); 
  ob1.hi();$skip(13); 
  ob1.hi(ob);$skip(19); 
  ob1.hi(obPerson);$skip(29); 
  
  val lst=List(1,2,3,4,5);System.out.println("""lst  : List[Int] = """ + $show(lst ))}
  
  
}
