package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Example interface implementation where value is an integer
 */
@Generated
public data class FirstInterfaceImplementation2(
  /**
   * Name of the first implementation
   */
  @get:JsonProperty(value = "name")
  override val name: String,
  /**
   * Custom field integer value
   */
  @get:JsonProperty(value = "intValue")
  public val intValue: Int,
) : BasicInterface2
