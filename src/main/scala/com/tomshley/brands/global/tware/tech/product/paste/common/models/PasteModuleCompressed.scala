package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util


case class PasteModuleCompressed(
                                  name: String,
                                  version: Float,
                                  requires: Seq[PasteModuleCompressed]
                                ) extends Model
