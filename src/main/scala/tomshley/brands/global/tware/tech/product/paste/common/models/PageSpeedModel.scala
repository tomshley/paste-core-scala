package tomshley.brands.global.tware.tech.product.paste.common.models

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.domain.Model

case class PageSpeedModel(
                           contentType: SupportedPasteAssetTypes.type,
                           assetByteSize: Int,
                           contentTypes: SupportedPasteAssetTypes,
                           skipNetwork: Boolean
                         ) extends Model