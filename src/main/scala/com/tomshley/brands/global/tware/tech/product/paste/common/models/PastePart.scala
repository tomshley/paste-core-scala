package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util.FilesUtil
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel


case class PastePart(
                      name: String,
                      pasteAssetType: PasteAssetType,
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

  def apply(sourceResourcePath: String): PastePart = {
    lazy val nameWithExtension = nameAndExtensionPair(sourceResourcePath)
    lazy val name: String = nameWithExtension(0)
    lazy val lastSlashIndex = name.lastIndexOf("/") + 1
    new PastePart(
      name.substring(lastSlashIndex, name.length),
      typeMatch(sourceResourcePath)
    )
  }

  private def typeMatch(filePath: String): PasteAssetType = PasteAssetType.values.filter { supportedType =>
    lazy val nameWithExtension = nameAndExtensionPair(filePath)
    Seq(".", supportedType.toFileExtension).mkString("") == nameWithExtension(1)
  }.head

  def apply(name: String, pasteAssetType: PasteAssetType): PastePart = {
    new PastePart(
      name,
      pasteAssetType = pasteAssetType
    )
  }
