package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.marshalling.PasteMarshallModel

case class PasteModule(
                        part: PastePart,
                        sourceResourcePath: String,
                        requiresParts: Array[PastePart],
                        optimizedPathOption: Option[String] = None,
                        parentBuildDirOption: Option[String] = None
                      ) extends PasteMarshallModel[PasteModule]

object PasteModule:
  def apply(part: PastePart,
            sourceResourcePath: String,
           ) = new PasteModule(part, sourceResourcePath, Array())
