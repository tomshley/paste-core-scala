package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.google.protobuf.compiler.plugin.CodeGeneratorResponse.File
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{IncomingModel, Model}


case class DependencySourceModel(
                                  dependency: Dependency,
                                  pathValue: String,
                                  contents: String,
                                  checksum: String,
                                  byteSize: String,
                                  priorVersions: Seq[Float],
                                  versionOption: Option[Float] = None
                                ) extends IncomingModel
