package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Example interface implementation where value is a float
 */
@Generated
public data class SecondInterfaceImplementation(
  /**
   * Unique identifier of the second implementation
   */
  @get:JsonProperty(value = "id")
  override val id: Int,
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
) : BasicInterface
