
package com.tomshley.brands.global.tware.tech.product.paste.common.ports.outgoing

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteJsonMarshalling
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{FileGatherCommand, ManifestCreatedEvent, PasteManifest}
import com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming.ParseModuleRequires

import scala.concurrent.{ExecutionContext, Future}

sealed trait ManifestLoaded extends Port[ManifestCreatedEvent, Future[String]] with PortAsyncExecution[ManifestCreatedEvent, Future[String]] {
  override def executeAsync(inboundModel: ManifestCreatedEvent)(implicit ec: ExecutionContext): Future[String] = {
    Future("")
  }
}

object ManifestLoaded extends ManifestLoaded
