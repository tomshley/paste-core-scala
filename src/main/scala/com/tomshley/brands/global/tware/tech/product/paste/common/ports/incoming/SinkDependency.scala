package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives.*
import akka.stream.scaladsl.{Concat, Flow, Source, StreamConverters}
import akka.util.ByteString
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{IncomingPort, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{SinkDependencyCommand, SourcedDependenciesCommand, SupportedPasteAssetType}

import java.net.URL
import scala.concurrent.ExecutionContext

sealed trait SinkDependency extends IncomingPort[SinkDependencyCommand, SourcedDependenciesCommand] with PortAsyncExecution[SinkDependencyCommand, SourcedDependenciesCommand] {
  given system: ActorSystem = ActorSystem(PasteCommonConfigKeys.IO_ACTOR_SYSTEM.toString)

  override def executeAsync(inboundModel: SinkDependencyCommand)(implicit ec: ExecutionContext): SourcedDependenciesCommand = {

    SourcedDependenciesCommand(
      inboundModel.supportedContentTypes,
      Source.combine(
        inboundModel.pasteModules.map { dependency =>
          getClass.getClassLoader.getResource(dependency.optimizedPathOption.fold(
            ifEmpty = dependency.sourceResourcePath
          )(resourcePath => resourcePath))
        }.map(pathUrl =>
          StreamConverters.fromInputStream(() => pathUrl.openStream())
        ).map(inputSource =>
          inputSource.via(
            Flow[ByteString].map(_.map(_.toChar.toByte))
          )
        ))(Concat[ByteString]).runReduce(_ ++ _)
    )

  }
}

object SinkDependency extends SinkDependency
