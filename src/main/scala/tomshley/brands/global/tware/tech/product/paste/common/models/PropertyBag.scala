package tomshley.brands.global.tware.tech.product.paste.common.models

import java.io.File

case class PropertyBag(
                              contentTypePaths: Seq[String],
                              compileMode: Boolean,
                              buildArea: String,
                              buildPrefix: String,
                              rootURI: String,
                              versioning: Boolean,
                              appRoot: File,
                              excludedDirs: Seq[File],
                              networkRequestThreshold: Int
                            )
