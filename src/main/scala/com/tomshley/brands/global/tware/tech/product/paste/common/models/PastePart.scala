package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys


case class PastePart(
                      name: String,
                      requires: Seq[PastePart],
                      versionOption: Option[Float] = None,
                    ) extends Model {

  lazy val version: Float = versionOption.fold(
    ifEmpty = PasteCommonConfigKeys.DEFAULT_VERSION.toValue.toFloat
  )(version => version)
}
