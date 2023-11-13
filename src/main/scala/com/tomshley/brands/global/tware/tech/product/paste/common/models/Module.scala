package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util.TimeUtils

import java.io.File



case class Module(
                            name: String,
                            version: Float,
                            requires: Seq[Module]
                          ) extends Model
