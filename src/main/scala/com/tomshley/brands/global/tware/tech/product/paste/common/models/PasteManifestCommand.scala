package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.PortInboundModel
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel

case class PasteManifestCommand(pasteModules: Array[PasteModule]) extends PasteMarshallModel[PasteManifestCommand] with PortInboundModel
