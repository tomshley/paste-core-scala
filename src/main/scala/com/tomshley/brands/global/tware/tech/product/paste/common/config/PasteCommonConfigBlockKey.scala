package com.tomshley.brands.global.tware.tech.product.paste.common.config

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.config.ConfigEnvOrFile

import scala.reflect.ClassTag

protected[paste] class PasteCommonConfigBlockKey[T](parentBlock: PasteCommonConfigBlocks, keyName: String, defaultValue: T) {
  override def toString: String = {
    toValue.toString
  }

  def toValue: T = {
    Option(
      ConfigEnvOrFile.config.envOrElseConfig(Seq(parentBlock.toBlockName, keyName).mkString("."))
    ).fold(
      ifEmpty = defaultValue
    )(value => value.asInstanceOf[T])
  }
}
