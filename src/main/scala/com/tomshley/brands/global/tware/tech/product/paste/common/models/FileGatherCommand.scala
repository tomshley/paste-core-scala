package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{PortInboundModel, Model}
import com.tomshley.brands.global.tware.tech.product.paste.common.models.PasteAssetType

case class FileGatherCommand(
                              resourcePaths: Seq[String],
                              supportedPasteAssetTypesOption: Option[Seq[PasteAssetType]],
                              buildDirNameOption: Option[String] = None
                            ) extends PortInboundModel {

  lazy val supportedPasteAssetTypes: Seq[PasteAssetType] = {
    supportedPasteAssetTypesOption.fold(
      ifEmpty = PasteAssetType.values.filter(_ != PasteAssetType.NONE).toSeq
    )(
      supportedTypes => supportedTypes
    )
  }
}

object FileGatherCommand:
  def apply(absPaths: String*) = new FileGatherCommand(
    absPaths, None, None
  )
