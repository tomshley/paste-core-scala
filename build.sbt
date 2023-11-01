lazy val pasteGroupName = "paste"
lazy val commonProjectName = Seq(pasteGroupName, "common").mkString("-")
lazy val pasteLibOrgName = "tomshley.brands.global.tware.tech.product.paste"

lazy val commonProject = publishableProject(commonProjectName, Some(file(".")))
  .enablePlugins(ProjectTemplatePlugin, ProjectsHelperPlugin, ProjectStructurePlugin, LibManagedProjectPlugin)
  .settings(
    name := commonProjectName,
    organization := pasteLibOrgName
  )
