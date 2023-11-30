package com.tomshley.brands.global.tware.tech.product.paste.common.ports

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.marshalling.PasteJsonMarshalling
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{FileGatherCommand, ManifestCreatedEvent, PasteManifest}

import java.nio.charset.StandardCharsets
import java.util.Base64
import scala.concurrent.{ExecutionContext, Future}

sealed trait CreateManifest extends Port[FileGatherCommand, Future[ManifestCreatedEvent]] with PortAsyncExecution[FileGatherCommand, Future[ManifestCreatedEvent]] {
  override def executeAsync(inboundModel: FileGatherCommand)(implicit ec: ExecutionContext): Future[ManifestCreatedEvent] = {
    ParseModuleRequires.executeAsync(inboundModel).map(pasteModuleSeq =>
      PasteManifest(pasteModuleSeq.toArray)
    ).map(pasteManifest =>
      PasteJsonMarshalling.serializeWithDefaultsAsync(pasteManifest, ec)
    ).flatMap(serializedStringFuture =>
      serializedStringFuture).map(serializedString =>
      ManifestCreatedEvent {
        Base64.getEncoder.encode(serializedString.getBytes(StandardCharsets.UTF_8))
      }
    )
  }
}

object CreateManifest extends CreateManifest
