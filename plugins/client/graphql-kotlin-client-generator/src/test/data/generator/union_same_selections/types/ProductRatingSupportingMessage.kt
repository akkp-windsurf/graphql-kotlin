package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonSubTypes
import com.fasterxml.jackson.`annotation`.JsonTypeInfo
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.As.PROPERTY
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.Id.NAME

@Generated
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "__typename",
  defaultImpl = DefaultProductRatingSupportingMessageImplementation::class,
)
@JsonSubTypes(value = [com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    ProductRatingLink::class,
    name="ProductRatingLink"),com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    EGDSPlainText::class, name="EGDSPlainText")])
public interface ProductRatingSupportingMessage
