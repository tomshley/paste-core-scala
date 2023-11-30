package com.tomshley.brands.global.tware.tech.product.paste.common.ports

import akka.Done
import akka.actor.ActorSystem
import akka.stream.scaladsl.Source
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.models.*

import java.nio.file.{Files, Paths}
import scala.concurrent.{ExecutionContext, Future}

sealed trait EnsureBuildDirectories extends Port[ResourceFileDirectoriesCommand, Future[Done]] with PortAsyncExecution[ResourceFileDirectoriesCommand, Future[Done]] {
  given system: ActorSystem = ActorSystem(PasteCommonConfigKeys.IO_ACTOR_SYSTEM.toString)

  override def executeAsync(inboundModel: ResourceFileDirectoriesCommand)(implicit ec: ExecutionContext): Future[Done] = {
    Source.fromIterator(() =>
      buildDirectoryGathering(
        inboundModel,
        GatherResourceFiles.execute(inboundModel)
      )
    ).map(p => {
      println(p)
      Files.createDirectories(
        p.buildDirPath
      )
    }).run()
  }

  private def buildDirectoryGathering(inboundModel: ResourceFileDirectoriesCommand, fileGatheringModel: FileGatherCommand): Iterator[BuildableFilePath] = {
    fileGatheringModel.resourcePaths
      .map(sourceResourcePath => {
        lazy val path = Paths.get(getClass.getClassLoader.getResource(sourceResourcePath).getFile)
        BuildableFilePath(
          path,
          Paths.get(Seq(path.getParent, inboundModel.buildDirName).mkString("/"))
        )
      }
      ).iterator
  }

}

object EnsureBuildDirectories extends EnsureBuildDirectories
