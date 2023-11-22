package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.IncomingModel
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys


case class SinkDependencyCommand(
                                  pasteModules: Seq[PasteModule] = Seq(),
                                  supportedContentTypes: Seq[PasteAssetType] = Seq()
                                ) extends IncomingModel {

  lazy val contentLocations: Map[PasteAssetType, Seq[String]] = {
    Map(
      PasteAssetType.JS -> List("paste/scripts"), //PasteCommonConfigKeys.CONTENT_DIR_SCRIPTS.toValue),
      //        (PasteAssetType.CSS -> PasteCommonConfigKeys.CONTENT_DIR_STYLES.toValue),
      //        (PasteAssetType.IMG -> PasteCommonConfigKeys.CONTENT_DIR_IMG.toValue)
    ).filter(supportedContentType => supportedContentTypes.contains(supportedContentType._1))
  }
}
