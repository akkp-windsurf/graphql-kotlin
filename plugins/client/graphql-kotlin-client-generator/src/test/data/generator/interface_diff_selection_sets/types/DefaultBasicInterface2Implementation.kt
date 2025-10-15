package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fallback BasicInterface2 implementation that will be used when unknown/unhandled type is
 * encountered.
 */
@Generated
public data class DefaultBasicInterface2Implementation(
  /**
   * Name field
   */
  @get:JsonProperty(value = "name")
  override val name: String,
) : BasicInterface2
