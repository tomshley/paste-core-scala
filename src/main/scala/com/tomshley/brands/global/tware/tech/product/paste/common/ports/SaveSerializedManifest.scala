
package com.tomshley.brands.global.tware.tech.product.paste.common.ports

import akka.actor.ActorSystem
import akka.stream.IOResult
import akka.stream.scaladsl.{FileIO, Source}
import akka.util.ByteString
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.models.ManifestCreatedEvent

import java.nio.file.Paths
import scala.concurrent.{ExecutionContext, Future}

object SaveSerializedManifest extends SaveSerializedManifest
sealed trait SaveSerializedManifest extends Port[Future[ManifestCreatedEvent], Future[String]] with PortAsyncExecution[Future[ManifestCreatedEvent], Future[IOResult]] {
  given system: ActorSystem = ActorSystem(PasteCommonConfigKeys.IO_ACTOR_SYSTEM.toString)

  override def executeAsync(inboundModel: Future[ManifestCreatedEvent])(implicit ec: ExecutionContext): Future[IOResult] = {
    Source.future(
      inboundModel.map(_.data_base64)
    ).map(
      s => ByteString(s)
    ).runWith(
      FileIO.toPath(
        Paths.get(
          Seq(
            Paths.get(
              getClass.getClassLoader.getResource(
                "paste"
              ).getFile
            ).toAbsolutePath.toString,
            PasteCommonConfigKeys.MANIFEST_NAME.toValueString
          ).mkString(
            "/"
          )
        )
      )
    )
  }
}

