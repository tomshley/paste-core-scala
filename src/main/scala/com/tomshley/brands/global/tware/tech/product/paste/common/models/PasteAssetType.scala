package com.tomshley.brands.global.tware.tech.product.paste.common.models


enum PasteAssetType extends java.lang.Enum[PasteAssetType]:
  case NONE, JS, CSS

  def toFileExtension: String = {
    toString.toLowerCase()
  }
end PasteAssetType

//  implicit val format: Format[PasteAssetType] = Json.formatEnum(this)

