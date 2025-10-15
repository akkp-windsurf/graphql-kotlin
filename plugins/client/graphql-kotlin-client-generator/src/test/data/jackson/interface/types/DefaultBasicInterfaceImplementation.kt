package com.expediagroup.graphql.generated.types

import com.expediagroup.graphql.client.Generated
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fallback BasicInterface implementation that will be used when unknown/unhandled type is
 * encountered.
 */
@Generated
public data class DefaultBasicInterfaceImplementation(
  /**
   * Unique identifier of an interface
   */
  @get:JsonProperty(value = "id")
  override val id: Int,
  /**
   * Name field
   */
  @get:JsonProperty(value = "name")
  override val name: String,
) : BasicInterface
