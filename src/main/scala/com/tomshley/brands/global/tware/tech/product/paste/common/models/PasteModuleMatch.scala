package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.marshalling.PasteMarshallModel

case class PasteModuleMatch(pastedocMatch: PastedocMatch, pasteModuleOption: Option[PasteModule] = None) extends PasteMarshallModel[PasteModuleMatch]
