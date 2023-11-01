package tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model

case class PageSpeedModel(
                           contentType: ContentTypes.type,
                           assetByteSize: Int,
                           contentTypes: ContentTypes,
                           skipNetwork: Boolean
                         ) extends Model