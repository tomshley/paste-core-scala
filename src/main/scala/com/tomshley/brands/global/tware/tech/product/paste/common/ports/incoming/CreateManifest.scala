package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteJsonMarshalling
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{FileGatherCommand, PasteManifest}
import java.util.Base64
import java.nio.charset.StandardCharsets
import scala.concurrent.{ExecutionContext, Future}

sealed trait CreateManifest extends Port[FileGatherCommand, Future[String]] with PortAsyncExecution[FileGatherCommand, Future[String]] {
  override def executeAsync(inboundModel: FileGatherCommand)(implicit ec: ExecutionContext): Future[String] = {
    ParseModuleRequires.executeAsync(inboundModel).map(pasteModuleSeq =>
      PasteManifest(pasteModuleSeq)
    ).transformWith(t =>
      PasteJsonMarshalling.serializeWithDefaultsAsync(t.getOrElse(PasteManifest(Seq())), ec)
    ).flatMap(serializedString => Future(java.util.Base64.getEncoder.encodeToString(serializedString.getBytes(StandardCharsets.UTF_8))))
  }
}

object CreateManifest extends CreateManifest
