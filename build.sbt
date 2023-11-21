lazy val pasteGroupName = "paste"
lazy val commonProjectName = Seq(pasteGroupName, "common").mkString("-")
lazy val pasteLibOrgName = "com.tomshley.brands.global.tware.tech.product.paste"

lazy val commonProject = publishableProject(commonProjectName, Some(file(".")))
  .enablePlugins(ProjectTemplatePlugin, ProjectsHelperPlugin, ProjectStructurePlugin, LibManagedProjectPlugin, LibProjectAkkaPlugin)
  .settings(
    name := commonProjectName,
    organization := pasteLibOrgName,
    libraryDependencies ++= Seq(
      "com.yahoo.platform.yui" % "yuicompressor" % "2.4.8",
      "com.google.javascript" % "closure-compiler" % "v20230802",
      "com.googlecode.htmlcompressor" % "htmlcompressor" % "1.5.2",
      "com.typesafe.akka" %% "akka-http-caching" % "10.6.0-M1"
    )
  )
