package com.tomshley.brands.global.tware.tech.product.paste.common.models


enum SupportedPasteAssetType:
  case NONE, JS, CSS, SCSS

  def toFileExtension: String = {
    toString.toLowerCase()
  }
