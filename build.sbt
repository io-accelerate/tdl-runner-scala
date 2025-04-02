ThisBuild / scalaVersion := "3.6.2"

name := "tdl-runner-scala"
version := "1.0"

resolvers += Resolver.mavenLocal

val scalatest    = "org.scalatest" %% "scalatest" % "3.2.17" % Test
val scalaxml     = "org.scala-lang.modules" %% "scala-xml" % "2.1.0"  // Updated for Scala 3
val client       = "io.accelerate" % "tdl-client-java" % "0.29.1"
val jacksonScala = "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.17.3"
val guava        = "com.google.guava" % "guava" % "31.1-jre" // Updated Guava version
val unirest      = "com.konghq" % "unirest-java" % "3.14.3" // Updated Unirest package

scalacOptions ++= Seq(
  "-Ykind-projector",  // Ensures better type inference
  "-Wunused:all",       // Enables all unused warnings
  "-source:future"      // Future-proofing
)

libraryDependencies ++= Seq(
  scalaxml,
  client,
  jacksonScala,
  guava,
  unirest,
  scalatest
)

coverageEnabled := true

lazy val tdlTests = taskKey[Unit]("Run tests for CI")

tdlTests := (Test / test).value

Test / testOptions += Tests.Argument("-oF") 
