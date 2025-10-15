package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import com.fasterxml.jackson.`annotation`.JsonSubTypes
import com.fasterxml.jackson.`annotation`.JsonTypeInfo
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.As.PROPERTY
import com.fasterxml.jackson.`annotation`.JsonTypeInfo.Id.NAME
import kotlin.Int

/**
 * Very basic interface
 */
@Generated
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME,
  include = JsonTypeInfo.As.PROPERTY,
  property = "__typename",
  defaultImpl = DefaultBasicInterface2Implementation::class,
)
@JsonSubTypes(value = [com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    FirstInterfaceImplementation2::class,
    name="FirstInterfaceImplementation"),com.fasterxml.jackson.annotation.JsonSubTypes.Type(value =
    SecondInterfaceImplementation2::class, name="SecondInterfaceImplementation")])
public interface BasicInterface2 {
  /**
   * Unique identifier of an interface
   */
  @get:JsonProperty(value = "id")
  public val id: Int
}
