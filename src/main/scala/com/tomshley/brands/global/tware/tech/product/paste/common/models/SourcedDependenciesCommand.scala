package com.tomshley.brands.global.tware.tech.product.paste.common.models

import akka.util.ByteString
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.IncomingModel

import scala.concurrent.Future

case class SourcedDependenciesCommand(
                                       supportedPasteAssetTypes: Seq[PasteAssetType],
                                       byteStringFuture: Future[ByteString]
                                     ) extends IncomingModel
