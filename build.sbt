name := "play_dredd_docker_at_travis"

enablePlugins(DockerPlugin)

version := "1.0"

lazy val `play_dredd_docker_at_travis` = (project in file(".")).enablePlugins(PlayScala)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(jdbc, ehcache, ws, specs2 % Test, guice)

unmanagedResourceDirectories in Test <+= baseDirectory(_ / "target/web/public/test")

dockerExposedPorts in Docker := Seq(9000, 9443)

packageName in Docker := "polls"

version in Docker := "1.0"