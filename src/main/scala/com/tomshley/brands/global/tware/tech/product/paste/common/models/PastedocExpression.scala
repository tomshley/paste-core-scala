package com.tomshley.brands.global.tware.tech.product.paste.common.models

import scala.util.matching.Regex

enum PastedocExpression(regex: Regex) {
  case JS_COMMENT extends PastedocExpression(
    "\\* @(module|requires)\\s".r
  )
  case JSDOC_MODULE extends PastedocExpression(
    new Regex(
      "@(module|requires)\\s([\\w||/.].+)", "type", "name"
    )
  )
  case CLOSURE_COMPILATION extends PastedocExpression(
    new Regex(
      "@(compilation_level)\\s([\\w].+)",
      "type",
      "value"
    )
  )

  def toRegex: Regex = regex
}
