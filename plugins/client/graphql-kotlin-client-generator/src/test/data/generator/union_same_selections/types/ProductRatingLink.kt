package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty

@Generated
public data class ProductRatingLink(
  @get:JsonProperty(value = "link")
  public val link: EGDSStandardLink,
  @get:JsonProperty(value = "action")
  public val action: EGDSProductRatingShowTextAction,
) : ProductRatingSupportingMessage
