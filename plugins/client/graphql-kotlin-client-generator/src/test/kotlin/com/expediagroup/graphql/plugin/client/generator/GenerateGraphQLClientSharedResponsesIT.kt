package com.expediagroup.graphql.plugin.client.generator

import org.junit.jupiter.api.Test
import java.io.File

class GenerateGraphQLClientSharedResponsesIT {
    @Test
    fun `generate client with shared response types across operations`() {
        val files = generateClient(
            packageName = "com.expediagroup.generated",
            allowDeprecated = false,
            customScalarsMap = emptyList(),
            serializer = GraphQLSerializer.JACKSON,
            schemaPath = "schema.graphql",
            queries = listOf(
                File("src/test/data/generator/shared_responses/Operation1.graphql"),
                File("src/test/data/generator/shared_responses/Operation2.graphql")
            ),
            useOptionalInputWrapper = false,
            useSharedResponseTypes = true
        )
        val namesByPackage = files.groupBy({ it.packageName }, { it.name }).mapValues { it.value.toSet() }
        check(namesByPackage["com.expediagroup.generated.responses"]?.containsAll(setOf("ComplexObject", "ComplexObject2", "ComplexObject3")) == true)
    }
}
