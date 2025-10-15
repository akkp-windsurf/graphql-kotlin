package com.expediagroup.graphql.plugin.client.generator

import org.junit.jupiter.api.Test

class GenerateGraphQLClientIT_SharedResponses {
    @Test
    fun `generate client with shared response types across operations`() {
        val files = generateClient(
            packageName = "com.expediagroup.generated",
            allowDeprecated = false,
            customScalarsMap = emptyList(),
            serializer = GraphQLSerializer.JACKSON,
            schemaPath = "schema.graphql",
            queries = listOf(
                java.io.File("src/test/data/generator/shared_responses/Operation1.graphql"),
                java.io.File("src/test/data/generator/shared_responses/Operation2.graphql")
            ),
            useOptionalInputWrapper = false,
            useSharedResponseTypes = true
        )
        val output = files.map { it.packageName to it.name }.toSet()
        require(output.contains("com.expediagroup.generated.responses" to "ComplexObject"))
        require(output.contains("com.expediagroup.generated.responses" to "ComplexObject2"))
        require(output.contains("com.expediagroup.generated.responses" to "ComplexObject3"))
    }
}

/*
 * Copyright 2021 Expedia, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.graphql.plugin.client.generator

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.File

class GenerateGraphQLClientIT {

    @ParameterizedTest
    @MethodSource("generatorTests")
    fun `verify generation of client code using default settings`(testDirectory: File) {
        verifyClientGeneration(defaultConfig, testDirectory)
    }

    companion object {
        @JvmStatic
        fun generatorTests(): List<Arguments> = locateTestCaseArguments("src/test/data/generator")
    }
}
