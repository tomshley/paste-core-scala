package com.tomshley.brands.global.tware.tech.product.paste.common.ports

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.IncomingPort
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.util.FilesUtil
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{FileGatherCommand, PasteAssetType, ResourceFileDirectoriesCommand}

import java.io.File

sealed trait GatherResourceFiles extends IncomingPort[ResourceFileDirectoriesCommand, FileGatherCommand] with FilesUtil {
  override def execute(inboundModel: ResourceFileDirectoriesCommand): FileGatherCommand = {
    val fallbackDirName = inboundModel.projectResourcesDirNameFallbackOption.fold(
      ifEmpty = ""
    )(dirName => dirName)

    lazy val regex = s".+\\.(${PasteAssetType.values.map(t => t.toFileExtension).distinct.mkString("|")})$$".r

    FileGatherCommand(
      (inboundModel.assetBuildDirectories.directoryMapping.flatten(_._2.toSeq).toSeq ++ Seq(fallbackDirName)).distinct.flatMap(resourceName => {
        lazy val file = new File(getClass.getClassLoader.getResource(resourceName).toURI)
        recursiveFileList(_.getName matches regex.regex)(file.getAbsoluteFile).map(recursiveFile => {
          if (recursiveFile.exists()) {
            Some(recursiveFile.getAbsolutePath.stripPrefix(file.getAbsoluteFile.getAbsolutePath.stripSuffix(resourceName)))
          } else {
            Option.empty[String]
          }
        }
        )
      }
      ).filter(_.isDefined).map(_.get) *
    )
  }
}

object GatherResourceFiles extends GatherResourceFiles
