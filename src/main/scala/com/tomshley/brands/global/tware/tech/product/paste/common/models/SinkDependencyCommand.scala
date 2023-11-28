package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.PortInboundModel


case class SinkDependencyCommand(
                                  pasteManifest: PasteManifest,
                                  supportedContentTypes: Seq[PasteAssetType] = Seq()
                                ) extends PortInboundModel
