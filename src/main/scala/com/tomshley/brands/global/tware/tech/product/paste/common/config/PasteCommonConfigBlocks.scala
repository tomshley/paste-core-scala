package com.tomshley.brands.global.tware.tech.product.paste.common.config

protected[paste] enum PasteCommonConfigBlocks(blockName: String) {
  case PASTE extends PasteCommonConfigBlocks("paste")

  def toBlockName: String = blockName
}
