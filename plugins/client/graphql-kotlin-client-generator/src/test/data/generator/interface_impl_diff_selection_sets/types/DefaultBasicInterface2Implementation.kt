package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Fallback BasicInterface2 implementation that will be used when unknown/unhandled type is
 * encountered.
 */
@Generated
public data class DefaultBasicInterface2Implementation(
  /**
   * Unique identifier of an interface
   */
  @get:JsonProperty(value = "id")
  override val id: Int,
) : BasicInterface2
