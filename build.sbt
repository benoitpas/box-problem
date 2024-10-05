ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.5.1"

lazy val root = (project in file("."))
  .settings(
    name := "box-problem"
  )

libraryDependencies ++= Seq(
  "com.github.sbt" % "junit-interface" % "0.13.3" % "test"
)
