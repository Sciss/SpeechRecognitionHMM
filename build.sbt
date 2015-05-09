name             := "SpeechRecognitionHMM"

version          := "0.1.0-SNAPSHOT"

organization     := "de.sciss"

description      := "Speech Recognition using VQ and HMM"

homepage         := Some(url("https://github.com/Sciss/" + name.value))

licenses         := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

scalaVersion     := "2.11.6"

crossPaths       := false  // this is just a Java project right now!

autoScalaLibrary := false

mainClass in Compile := Some("org.ioe.tprsa.ui.HMM_VQ_Speech_Recognition")

javacOptions in (Compile, compile) ++= Seq("-g", "-source", "1.6", "-target", "1.6")

fork in run := true

// ---- publishing ----

publishMavenStyle := true

publishTo :=
  Some(if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := { val n = name.value
<scm>
  <url>git@github.com:Sciss/{n}.git</url>
  <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
</scm>
<developers>
  <developer>
    <id>gtiwari333</id>
    <name>Ganesh Tiwari</name>
    <url>http://ganeshtiwaridotcomdotnp.blogspot.com</url>
  </developer>
  <developer>
    <id>sciss</id>
    <name>Hanns Holger Rutz</name>
    <url>http://www.sciss.de</url>
  </developer>
</developers>
}
