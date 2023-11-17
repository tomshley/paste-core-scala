package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel

case class PasteModuleMatch(pasteModule: PasteModule, pastedocMatch: PastedocMatch) extends PasteMarshallModel[PasteModuleMatch]
