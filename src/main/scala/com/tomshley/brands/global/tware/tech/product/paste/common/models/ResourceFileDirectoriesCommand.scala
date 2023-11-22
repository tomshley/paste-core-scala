package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{IncomingModel, Model}
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys

case class ResourceFileDirectoriesCommand(
                                           assetBuildDirectories: AssetBuildDirectories,
                                           projectResourcesDirNameFallbackOption: Option[String] = None,
                                           buildDirNameOption: Option[String] = None
                                         ) extends Model with IncomingModel {
  lazy val buildDirName: String = buildDirNameOption.fold(
    ifEmpty = PasteCommonConfigKeys.BUILD_DIR_NAME.toValueString
  )(name => name)
}
