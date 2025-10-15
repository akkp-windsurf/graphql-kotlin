package com.expediagroup.generated

import com.expediagroup.graphql.client.Generated
import com.expediagroup.graphql.client.types.GraphQLClientRequest
import kotlin.String
import kotlin.reflect.KClass

@Generated
class Operation1 : GraphQLClientRequest<Operation1.Result> {
  override val query: String = OPERATION_1

  override val operationName: String = "Operation1"

  override fun responseType(): KClass<Result> = Result::class

  class Result(
    val first: com.expediagroup.generated.responses.ComplexObject,
    val second: com.expediagroup.generated.responses.ComplexObject2,
    val third: com.expediagroup.generated.responses.ComplexObject3,
    val fourth: com.expediagroup.generated.responses.ComplexObject,
    val fifth: com.expediagroup.generated.responses.ComplexObject2,
  )
}

const val OPERATION_1: String =
    "query Operation1 {\n  first: complexObjectQuery {\n    id\n    name\n  }\n  second: complexObjectQuery {\n    id\n    name\n    details {\n      id\n      value\n    }\n  }\n  third: complexObjectQuery {\n    id\n    name\n    details {\n      id\n    }\n  }\n  fourth: complexObjectQuery {\n    id\n    name\n  }\n  fifth: complexObjectQuery {\n    id\n    name\n    details {\n      id\n      value\n    }\n  }\n}"
