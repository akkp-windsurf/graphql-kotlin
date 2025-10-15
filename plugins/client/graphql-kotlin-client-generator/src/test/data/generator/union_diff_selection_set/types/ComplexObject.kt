package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Multi line description of a complex type.
 * This is a second line of the paragraph.
 * This is final line of the description.
 */
@Generated
public data class ComplexObject(
  /**
   * Some unique identifier
   */
  @get:JsonProperty(value = "id")
  public val id: Int,
) : BasicUnion
