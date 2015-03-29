
name := "testAkka"

version   := 	"1.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
                      "com.typesafe" % "config" % "1.2.1","ch.qos.logback"       %     "logback-classic"          %      "1.0.13",
			"com.typesafe.akka" %%  "akka-actor" % "2.3.9"
                    )
parallelExecution in Test:=false
