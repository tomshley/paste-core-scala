package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util.FilesUtil
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel

import java.nio.file.Path


case class PastePart(
                      name: String,
                      pasteAssetType: SupportedPasteAssetType,
                      versionOption: Option[String] = None
                    ) extends PasteMarshallModel[PastePart] {

  lazy val version: String = versionOption.fold(
    ifEmpty = PasteCommonConfigKeys.DEFAULT_VERSION.toValue
  )(version => version)

  lazy val versionedName: String = {
    Seq(name, Seq("v", version).mkString("")).mkString(".")
  }
}

object PastePart extends FilesUtil:
  def apply(sourcePath: Path): PastePart = {
    apply(sourcePath, Seq())
  }

  def apply(sourcePath: Path, requires: Seq[PastePart]): PastePart = {
    lazy val nameWithExtension = nameAndExtensionPair(sourcePath.getFileName.toString)

    new PastePart(
      nameWithExtension(0),
      typeMatch(sourcePath.getFileName.toString)
    )
  }

  private def typeMatch(filePath: String): SupportedPasteAssetType = SupportedPasteAssetType.values.filter { supportedType =>
    lazy val nameWithExtension = nameAndExtensionPair(filePath)

    Seq(".", supportedType.toFileExtension).mkString("") == nameWithExtension(1)
  }.head

  def apply(name: String, pasteAssetType: SupportedPasteAssetType): PastePart = {
    new PastePart(
      name,
      pasteAssetType = pasteAssetType
    )
  }
