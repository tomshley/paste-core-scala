package com.tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model

case class ContentTypedManifestModel(
                                      contentType: SupportedPasteAssetTypes.type,
                                      manifestModel: ManifestModel,
                                      sortedDependencies: Seq[DependencyModel]) extends Model