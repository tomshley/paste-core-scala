package com.tomshley.brands.global.tware.tech.product.paste.common.marshalling

import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.marshalling.models.MarshallModel
import com.tomshley.brands.global.tech.tware.products.hexagonal.lib.marshalling.{JsonMarshaller, models, serializers}
import com.tomshley.brands.global.tware.tech.product.paste.common.models.{PasteAssetType, PastePartType, PastedocExpression}
import org.json4s.{DefaultFormats, Formats}

import scala.concurrent.{ExecutionContext, Future}
import scala.languageFeature.postfixOps
import scala.reflect.ClassTag

sealed trait PasteJsonMarshalling extends JsonMarshaller {
  override def serializeWithDefaults[T <: MarshallModel[T] : Manifest](model: T)(
    implicit formats: Formats = pasteFormat
  ): String = {
    super.serializeWithDefaults(model)
  }

  override def deserializeWithDefaults[T <: MarshallModel[T] : Manifest](json: String)(
    implicit formats: Formats = pasteFormat
  ): T = super.deserializeWithDefaults(json)

  override def serializeWithDefaultsAsync[T <: MarshallModel[T] : Manifest](model: T, ec: ExecutionContext)(
    implicit formats: Formats = pasteFormat
  ): Future[String] = super.serializeWithDefaultsAsync(model, ec)

  override def deserializeWithDefaultsAsync[T <: MarshallModel[T] : Manifest](json: String, ec: ExecutionContext)(
    implicit formats: Formats = pasteFormat
  ): Future[T] = super.deserializeWithDefaultsAsync(json, ec)

  private def pasteFormat = DefaultFormats.preservingEmptyValues +
    new serializers.DateTimeSerializer +
    new serializers.AbsPathFileSerializer +
    new serializers.AbsPathSerializer +
    new serializers.JavaEnumNameSerializer[PastePartType] +
    new serializers.JavaEnumNameSerializer[PasteAssetType] +
    new serializers.JavaEnumNameSerializer[PastedocExpression]
}

object PasteJsonMarshalling extends PasteJsonMarshalling
