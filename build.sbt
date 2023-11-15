lazy val pasteGroupName = "paste"
lazy val commonProjectName = Seq(pasteGroupName, "common").mkString("-")
lazy val pasteLibOrgName = "com.tomshley.brands.global.tware.tech.product.paste"

lazy val commonProject = publishableProject(commonProjectName, Some(file(".")))
  .enablePlugins(ProjectTemplatePlugin, ProjectsHelperPlugin, ProjectStructurePlugin, LibManagedProjectPlugin)
  .settings(
    name := commonProjectName,
    organization := pasteLibOrgName,
    libraryDependencies ++= Seq(
      "io.bullet" %% "borer-core" % "1.12.0",
      "io.bullet" %% "borer-derivation" % "1.12.0"
    )
  )
