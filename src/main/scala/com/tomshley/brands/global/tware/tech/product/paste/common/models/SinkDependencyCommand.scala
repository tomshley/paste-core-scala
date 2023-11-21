package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.IncomingModel
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys


case class SinkDependencyCommand(
                                  pasteModules: Seq[PasteModule] = Seq(),
                                  supportedContentTypes: Seq[SupportedPasteAssetType] = Seq()
                                ) extends IncomingModel {

  lazy val contentLocations: Map[SupportedPasteAssetType, Seq[String]] = {
    Map(
      SupportedPasteAssetType.JS -> List("paste/scripts"), //PasteCommonConfigKeys.CONTENT_DIR_SCRIPTS.toValue),
      //        (SupportedPasteAssetType.CSS -> PasteCommonConfigKeys.CONTENT_DIR_STYLES.toValue),
      //        (SupportedPasteAssetType.IMG -> PasteCommonConfigKeys.CONTENT_DIR_IMG.toValue)
    ).filter(supportedContentType => supportedContentTypes.contains(supportedContentType._1))
  }
}
