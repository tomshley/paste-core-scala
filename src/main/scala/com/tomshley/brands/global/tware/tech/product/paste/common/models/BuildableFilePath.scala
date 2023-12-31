package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.marshalling.PasteMarshallModel
import java.nio.file.Path

case class BuildableFilePath(
                              path: Path, buildDirPath: Path
                            ) extends PasteMarshallModel[BuildableFilePath]
