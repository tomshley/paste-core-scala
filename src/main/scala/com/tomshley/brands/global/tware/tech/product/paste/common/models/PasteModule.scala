package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tware.tech.product.paste.common.config.PasteCommonConfigKeys
import com.tomshley.brands.global.tware.tech.product.paste.common.marshalling.PasteMarshallModel
import upickle.default.ReadWriter

import java.io.File

case class PasteModule(
                        part: PastePart,
                        sourceFile: File,
                        requiresParts: Seq[PastePart],
                        optimizedFileOption: Option[File] = None,
                        parentBuildDirOption: Option[File] = None
                      ) extends PasteMarshallModel[PasteModule] {

  lazy val expectedOptimizedFile: File = {
    optimizedFileOption.fold(
      ifEmpty = parentBuildDirOption.fold(
        ifEmpty = new File(
          Seq(
            sourceFile.getParent,
            PasteCommonConfigKeys.BUILD_DIR_NAME.toValue
          ).mkString("/")
        )
      )(buildDir => buildDir)
    )(optimizedFile => optimizedFile)
  }
}

object PasteModule:
  def apply(part: PastePart,
            sourceFile: File,
           ) = new PasteModule(part, sourceFile, Seq())
