package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Example interface implementation where value is an integer
 */
@Generated
public data class FirstInterfaceImplementation(
  /**
   * Unique identifier of the first implementation
   */
  @get:JsonProperty(value = "id")
  override val id: Int,
  /**
   * Custom field integer value
   */
  @get:JsonProperty(value = "intValue")
  public val intValue: Int,
) : BasicInterface
