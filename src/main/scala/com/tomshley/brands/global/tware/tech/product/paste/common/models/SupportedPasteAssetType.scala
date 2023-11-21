package com.tomshley.brands.global.tware.tech.product.paste.common.models


enum SupportedPasteAssetType extends java.lang.Enum[SupportedPasteAssetType]:
  case NONE, JS, CSS

  def toFileExtension: String = {
    toString.toLowerCase()
  }
end SupportedPasteAssetType

//  implicit val format: Format[SupportedPasteAssetType] = Json.formatEnum(this)

