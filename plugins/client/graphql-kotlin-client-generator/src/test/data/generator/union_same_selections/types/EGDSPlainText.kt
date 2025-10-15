package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Generated
public data class EGDSPlainText(
  @get:JsonProperty(value = "text")
  public val text: String,
) : ProductRatingSupportingMessage,
    ProductSupportingMessage
