package com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.config

protected[paste] enum PasteCommonConfigBlocks(blockName: String) {
  case PASTE extends PasteCommonConfigBlocks("paste")
  case PASTE_DIRECTORY_MAP extends PasteCommonConfigBlocks("paste.directories")

  def toBlockName: String = blockName
}
