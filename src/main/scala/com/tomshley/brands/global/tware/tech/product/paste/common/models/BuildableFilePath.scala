package com.tomshley.brands.global.tware.tech.product.paste.common.models

import java.nio.file.Path

case class BuildableFilePath(
                              path: Path, buildDirPath: Path
                            ) extends PasteSerializableModel
