package tomshley.brands.global.tware.tech.product.paste.common.config

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.config.ConfigEnvOrFile

protected[paste] class PasteCommonConfigBlockKey(parentBlock: PasteCommonConfigBlocks, keyName: String, defaultValueOption: Option[Any] = None) {
  override def toString: String = {
    Option(ConfigEnvOrFile.config.envOrElseConfig(Seq(parentBlock.toBlockName, keyName).mkString("."))).filter(_.nonEmpty).getOrElse(defaultValueOption.getOrElse(None)).toString
  }
}
