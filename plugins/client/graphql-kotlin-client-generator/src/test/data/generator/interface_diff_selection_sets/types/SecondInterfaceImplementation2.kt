package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Example interface implementation where value is a float
 */
@Generated
public data class SecondInterfaceImplementation2(
  /**
   * Name of the second implementation
   */
  @get:JsonProperty(value = "name")
  override val name: String,
  /**
   * Custom field float value
   */
  @get:JsonProperty(value = "floatValue")
  public val floatValue: Double,
) : BasicInterface2
