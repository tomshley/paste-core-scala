package com.tomshley.brands.global.tware.tech.product.paste.common.infrastructure.marshalling

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.marshalling.models.MarshallModel

class PasteMarshallModel[T <: PasteMarshallModel[T]] extends Model with MarshallModel[T]
