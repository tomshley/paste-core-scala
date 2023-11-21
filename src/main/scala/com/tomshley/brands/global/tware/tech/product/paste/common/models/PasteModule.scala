package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel

import java.io.File
import java.nio.file.{Path, Paths}

case class PasteModule(
                        part: PastePart,
                        sourceResourcePath: String,
                        requiresParts: Seq[PastePart],
                        optimizedPathOption: Option[String] = None,
                        parentBuildDirOption: Option[String] = None
                      ) extends PasteMarshallModel[PasteModule]

object PasteModule:
  def apply(part: PastePart,
            sourceResourcePath: String,
           ) = new PasteModule(part, sourceResourcePath, Seq())
