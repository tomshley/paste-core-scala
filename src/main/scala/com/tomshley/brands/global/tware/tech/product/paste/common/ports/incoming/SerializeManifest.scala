package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{OutgoingPort, PortAsyncExecution, Port}
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteJsonMarshalling
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{PasteManifest, PasteManifestCommand}
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys

import scala.concurrent.{ExecutionContext, Future}

import akka.actor.ActorSystem
trait SerializeManifest extends Port[PasteManifestCommand, Future[String]] with PortAsyncExecution[PasteManifestCommand, Future[String]] {
  given system: ActorSystem = ActorSystem(PasteCommonConfigKeys.IO_ACTOR_SYSTEM.toString)

  override def executeAsync(inboundModel: PasteManifestCommand)(implicit ec: ExecutionContext): Future[String] = {
    PasteJsonMarshalling.serializeWithDefaultsAsync(PasteManifest(inboundModel.pasteModules), ec)
  }
}

object SerializeManifest extends SerializeManifest
