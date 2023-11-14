package com.tomshley.brands.global.tware.tech.product.paste.common.models


enum SupportedPasteAssetTypes:
  case NONE, JS, CSS, SCSS

  def toFileExtension: String = {
    toString.toLowerCase()
  }
