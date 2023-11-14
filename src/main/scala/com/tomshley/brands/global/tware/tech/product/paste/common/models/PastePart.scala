package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util.FilesUtil
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys

import java.nio.file.Path


case class PastePart(
                      name: String,
                      pasteAssetType: SupportedPasteAssetTypes,
                      versionOption: Option[Float] = None,
                    ) extends Model {

  lazy val version: Float = versionOption.fold(
    ifEmpty = PasteCommonConfigKeys.DEFAULT_VERSION.toValue.toFloat
  )(version => version)

  lazy val versionedName: String = {
    Seq(name, Seq("v", version).mkString("")).mkString(".")
  }
}

object PastePart extends FilesUtil:
  private def typeMatch(filePath:String): SupportedPasteAssetTypes = SupportedPasteAssetTypes.values.filter { supportedType =>
    lazy val nameWithExtension = nameAndExtensionPair(filePath)

    Seq(".", supportedType.toFileExtension).mkString("") == nameWithExtension(1)
  }.head
  def apply(sourcePath: Path): PastePart = {
    apply(sourcePath, Seq())
  }
  def apply(name: String, pasteAssetType: SupportedPasteAssetTypes): PastePart = {
    new PastePart(
      name,
      pasteAssetType = pasteAssetType
    )
  }

  def apply(sourcePath: Path, requires: Seq[PastePart]): PastePart = {
    lazy val nameWithExtension = nameAndExtensionPair(sourcePath.getFileName.toString)

    new PastePart(
      nameWithExtension(0),
      typeMatch(sourcePath.getFileName.toString)
    )
  }
