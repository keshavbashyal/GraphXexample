import sbt.Keys._

name := "GraphXexample"

version := "1.0"

scalaVersion := "2.11.7"


resolvers ++= Seq(
  "Local Maven Repo" at "file://" + Path.userHome.absolutePath + "/.m2/repository"

)


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.4.1",
  "org.apache.spark" %% "spark-graphx" % "1.4.1",
  "org.encog" % "encog-core" % "3.2.0",
  "org.deeplearning4j" % "deeplearning4j-core" % "0.0.3.5.5.5",
  "org.deeplearning4j" % "deeplearning4j-scaleout-akka" % "0.0.3.5.5.5",
  "org.deeplearning4j" % "deeplearning4j-nlp" % "0.0.3.5.5.5",
  "org.nd4j" % "nd4j-api" % "0.0.3.5.5.5",
  "org.nd4j" % "nd4j-jblas" % "0.0.3.5.5.5"

)