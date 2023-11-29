package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Model, PortInboundModel}
import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.config.PasteCommonConfigKeys

case class ResourceFileDirectoriesCommand(
                                           assetBuildDirectories: AssetBuildDirectories,
                                           projectResourcesDirNameFallbackOption: Option[String] = None,
                                           buildDirNameOption: Option[String] = None
                                         ) extends Model with PortInboundModel {
  lazy val buildDirName: String = buildDirNameOption.fold(
    ifEmpty = PasteCommonConfigKeys.BUILD_DIR_NAME.toValueString
  )(name => name)
}
