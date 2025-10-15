package com.expediagroup.generated

import com.expediagroup.generated.responses.ComplexObject
import com.expediagroup.generated.responses.ComplexObject2
import com.expediagroup.generated.responses.ComplexObject3
import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import kotlin.String
import kotlin.reflect.KClass

@Generated
class Operation2 : GraphQLClientRequest<Operation2.Result> {
  override val query: String = OPERATION_2

  override val operationName: String = "Operation2"

  override fun responseType(): KClass<Result> = Result::class

  class Result(
    val first: ComplexObject,
    val second: ComplexObject2,
    val third: ComplexObject3,
    val fourth: ComplexObject,
    val fifth: ComplexObject2,
  )
}

const val OPERATION_2: String =
    "query Operation2 {\n  first: complexObjectQuery {\n    id\n    name\n  }\n  second: complexObjectQuery {\n    id\n    name\n    details {\n      id\n      value\n    }\n  }\n  third: complexObjectQuery {\n    id\n    name\n    details {\n      id\n    }\n  }\n  fourth: complexObjectQuery {\n    id\n    name\n  }\n  fifth: complexObjectQuery {\n    id\n    name\n    details {\n      id\n      value\n    }\n  }\n}"
