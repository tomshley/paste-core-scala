package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel
import com.tomshley.brands.global.tware.tech.product.paste.common.models.PastePartType.NONE
import upickle.default.ReadWriter

case class PastedocMatch(
                          pastePartType: PastePartType,
                          partName: String
                        ) extends PasteMarshallModel[PastedocMatch]

object PastedocMatch:
  def apply(pastePartTypeMatchValue: String, partName: String) = new PastedocMatch(
    PastePartType.values.find(partName => partName.toString.toLowerCase == pastePartTypeMatchValue).getOrElse(NONE),
    partName
  )
