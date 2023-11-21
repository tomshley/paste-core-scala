package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import akka.actor.ActorSystem
import akka.stream.scaladsl.{FileIO, Flow, Framing, Merge, Sink, Source}
import akka.util.ByteString
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.{Port, PortAsyncExecution}
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.models
import com.tomshley.brands.global.tware.tech.product.paste.common.models.*

import java.nio.file.Paths
import scala.concurrent.{ExecutionContext, Future}


sealed trait ParseModuleRequires extends Port[FileGatherCommand, Future[Seq[PasteModule]]] with PortAsyncExecution[FileGatherCommand, Future[Seq[PasteModule]]] {
  private lazy val pastedocSink = Sink.seq[PasteModule]

  given system: ActorSystem = ActorSystem(PasteCommonConfigKeys.IO_ACTOR_SYSTEM.toString)

  override def executeAsync(inboundModel: FileGatherCommand)(implicit ec: ExecutionContext): Future[Seq[PasteModule]] = {
    Source.combine(
      inboundModel.resourcePaths.map(path => {
        PasteModule(
          PastePart(
            path
          ),
          path
        )
      }
      ).map(pasteModule => {
        val resource = getClass.getClassLoader.getResource(
          pasteModule.sourceResourcePath
        )
        val path = Paths.get(
          resource.getFile
        )
        val fileIO = FileIO.fromPath(
          path
        )
        fileIO.via(matchPastDocFlow(pasteModule))
      })
    )(Merge(_)).runWith(pastedocSink)
  }

  private def matchPastDocFlow(pasteModule: PasteModule) =
    Framing.delimiter(ByteString(System.lineSeparator()), maximumFrameLength = 2048, allowTruncation = true)
      .filter { byteString =>
        PastedocExpression.JS_COMMENT.toRegex.findFirstMatchIn(byteString.utf8String).isDefined
      }.map { byteString =>
        val pastedocExpressionMatch = PastedocExpression.JSDOC_MODULE.toRegex.findFirstMatchIn(byteString.utf8String)
        // For later reference:
        //        m foreach {
        //          m => {
        //            println(m.group(0)) // the full match e.g. @requiresParts paste
        //            println(m.group(1)) // the type e.g. requiresParts
        //            println(m.group(2)) // the module name e.g. paste
        //          }
        //        }

        PasteModuleMatch(
          PastedocMatch(
            pastedocExpressionMatch.get.group(1), // Note: since we run a qualifier in the previous step, rely on the group being there
            pastedocExpressionMatch.get.group(2) // Note: since we run a qualifier in the previous step, rely on the group being there
          ),
          Some(pasteModule)
        )
      }.fold(Some(pasteModule)) {
        (lastPastModuleOption: Option[PasteModule], nextPasteModuleMatch: PasteModuleMatch) => {
          lazy val requires: Seq[PastePart] = nextPasteModuleMatch.pastedocMatch.pastePartType match
            case PastePartType.REQUIRES => Seq(
              PastePart(
                nextPasteModuleMatch.pastedocMatch.partName,
                pasteModule.part.pasteAssetType
              )
            )
            case _ => Seq()

          lastPastModuleOption match
            case Some(value) =>

              lazy val modulePart = nextPasteModuleMatch.pastedocMatch.pastePartType match
                case PastePartType.MODULE => PastePart(
                  nextPasteModuleMatch.pastedocMatch.partName,
                  value.part.pasteAssetType,
                  value.part.versionOption
                )
                case _ => value.part

              Some(PasteModule(
                modulePart,
                value.sourceResourcePath,
                value.requiresParts ++ requires,
                value.optimizedPathOption,
                value.parentBuildDirOption
              ))
            case None => Option.empty[PasteModule]
        }
      }.filter(
        _.isDefined
      ).map(
        _.get
      )
}

object ParseModuleRequires extends ParseModuleRequires
