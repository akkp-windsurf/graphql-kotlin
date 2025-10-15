package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonSubTypes
import com.fasterxml.jackson.`annotation`.JsonTypeInfo
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.As.PROPERTY
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.Id.NAME

/**
 * Very basic union of BasicObject and ComplexObject
 */
@Generated
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "__typename",
  defaultImpl = DefaultBasicUnion2Implementation::class,
)
@JsonSubTypes(value = [com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    BasicObject2::class,
    name="BasicObject"),com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    ComplexObject2::class, name="ComplexObject")])
public interface BasicUnion2
