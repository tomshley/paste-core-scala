package com.tomshley.brands.global.tware.tech.product.paste.common.ports.incoming

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Port
import com.tomshley.brands.global.tware.tech.product.paste.common.models.PasteModule

sealed trait CompressDependency extends Port[PasteModule, PasteModule] {
  //  YUICompressor.main()
}

object CompressDependency extends CompressDependency
