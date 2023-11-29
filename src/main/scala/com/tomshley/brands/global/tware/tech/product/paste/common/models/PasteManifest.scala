package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util.TimeUtils
import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.marshalling.PasteMarshallModel

case class PasteManifest(
                          pasteModules: Array[PasteModule] = Array(),
                          createdTimestamp: TimeUtils.DateTime = TimeUtils.DateTime.now()
                        ) extends PasteMarshallModel[PasteManifest]

