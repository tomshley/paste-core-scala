package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import akka.actor.ActorSystem
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.marshalling.PasteJsonMarshalling
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{PasteManifest, PasteManifestCommand}

import scala.concurrent.{ExecutionContext, Future}

trait SerializeManifest extends Port[PasteManifestCommand, Future[String]] with PortAsyncExecution[PasteManifestCommand, Future[String]] {
  given system: ActorSystem = ActorSystem(PasteCommonConfigKeys.IO_ACTOR_SYSTEM.toString)

  override def executeAsync(inboundModel: PasteManifestCommand)(implicit ec: ExecutionContext): Future[String] = {
    PasteJsonMarshalling.serializeWithDefaultsAsync(PasteManifest(inboundModel.pasteModules), ec)
  }
}

object SerializeManifest extends SerializeManifest
