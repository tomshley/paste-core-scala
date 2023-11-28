package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys

case class AssetBuildDirectories(directoryMappingOption: Option[Map[PasteAssetType, Seq[String]]] = None) extends Model {
  lazy val directoryMapping: Map[PasteAssetType, Seq[String]] = {
    directoryMappingOption.fold(
      ifEmpty = Map(
        PasteAssetType.JS -> PasteCommonConfigKeys.CONTENT_DIR_SCRIPTS.toValueString.split(",").toSeq
      )
    )(mapping => mapping)
  }
}
