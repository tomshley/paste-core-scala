
package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Flow, Sink, StreamConverters}
import akka.util.ByteString
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteJsonMarshalling
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{LoadManifestCommand, PasteManifest}

import java.net.URL
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import java.util.Base64
import scala.concurrent.{ExecutionContext, Future}

sealed trait LoadManifest extends Port[LoadManifestCommand, Future[PasteManifest]] with PortAsyncExecution[LoadManifestCommand, Future[PasteManifest]] {
  lazy val manifestSink = Sink.seq[PasteManifest]

  given system: ActorSystem = ActorSystem(PasteCommonConfigKeys.IO_ACTOR_SYSTEM.toString)

  override def executeAsync(inboundModel: LoadManifestCommand)(implicit ec: ExecutionContext): Future[PasteManifest] = {
    inboundModel.assetBuildDirectories.directoryMapping.flatMap(
      _._2
    ).map(path => {
      Seq(
        "paste", //path,
        PasteCommonConfigKeys.MANIFEST_NAME.toValueString
      ).mkString("/")
    }
    ).map(path =>
      getClass.getClassLoader.getResource(path)
    ).find(resourceURI =>
      Paths.get(resourceURI.getFile).toFile.exists()
    ) match
      case Some(value: URL) => {
        StreamConverters.fromInputStream(
          () => value.openStream()
        ).via(Flow[ByteString].map(
          byteString => byteString.map(
            byte => byte
          )
        ).map(byteString =>
          new String(Base64.getDecoder.decode(byteString.utf8String), StandardCharsets.UTF_8)
        )
        ).runReduce(
          _ + _
        ).transformWith(
          x => PasteJsonMarshalling.deserializeWithDefaultsAsync[PasteManifest](
            x.getOrElse(""),
            ec
          )
        )
      }
      case None => {
        Future.successful(PasteManifest())
      }
  }
}

object LoadManifest extends LoadManifest
