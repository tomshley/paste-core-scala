package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.IncomingModel
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel

case class PasteManifestCommand(pasteModules: Seq[PasteModule]) extends PasteMarshallModel[PasteManifestCommand] with IncomingModel
