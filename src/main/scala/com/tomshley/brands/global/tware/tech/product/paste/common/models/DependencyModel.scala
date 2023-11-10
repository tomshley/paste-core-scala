package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util.TimeUtils

import java.io.File

trait Dependency {
  lazy val lastModifiedTimestamp: TimeUtils.DateTime
  lazy val priorLastModifiedTimestamp: TimeUtils.DateTime
  lazy val hasVersionMismatch: Boolean
  val name: String
  val version: Float
}

case class DependencyModel(
                            name: String,
                            version: Float,
                          ) extends Model with Dependency {
  override lazy val lastModifiedTimestamp: util.TimeUtils.DateTime = ???
  override lazy val priorLastModifiedTimestamp: util.TimeUtils.DateTime = ???
  override lazy val hasVersionMismatch: Boolean = ???
}
