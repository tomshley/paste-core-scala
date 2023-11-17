lazy val pasteGroupName = "paste"
lazy val commonProjectName = Seq(pasteGroupName, "common").mkString("-")
lazy val pasteLibOrgName = "com.tomshley.brands.global.tware.tech.product.paste"

lazy val commonProject = publishableProject(commonProjectName, Some(file(".")))
  .enablePlugins(ProjectTemplatePlugin, ProjectsHelperPlugin, ProjectStructurePlugin, LibManagedProjectPlugin)
  .settings(
    name := commonProjectName,
    organization := pasteLibOrgName,
    libraryDependencies ++= Seq(
//      "io.bullet" %% "borer-core" % "1.12.0",
//      "io.bullet" %% "borer-derivation" % "1.12.0",
//      "org.json4s" %% "json4s-native" % "4.1.0-M3",
//      "org.json4s" %% "json4s-jackson" % "4.1.0-M3",
//      "org.json4s" %% "json4s-ext" % "4.1.0-M3",
//      "com.lihaoyi" %% "upickle" % "3.1.3",
//      "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.15.3",
//      "com.lihaoyi" %% "upickle-implicits" % "3.1.3",
      // Use the %%% operator instead of %% for Scala.js and Scala Native
//      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % "2.24.4",
      // Use the "provided" scope instead when the "compile-internal" scope is not supported
//      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.24.4" % "compile-internal"
    )
  )
