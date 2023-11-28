package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Port
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{PasteManifest, PasteModule}

sealed trait SortDependenciesTopology extends Port[PasteManifest, PasteModule] {
  // UNDER CONSTRUCTION
}

object SortDependenciesTopology extends SortDependenciesTopology
