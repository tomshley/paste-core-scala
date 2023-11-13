package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model

import java.io.File

case class PasteModule(
                        partialModel: PastePart,
                        sourceFile: File,
                        optimizedFileOption: Option[File] = None
                      ) extends Model
