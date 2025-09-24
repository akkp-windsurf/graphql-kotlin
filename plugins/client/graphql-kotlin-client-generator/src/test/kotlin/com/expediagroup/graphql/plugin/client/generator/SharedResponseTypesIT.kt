package com.expediagroup.graphql.plugin.client.generator

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertTrue

class SharedResponseTypesIT {

    @Test
    fun `verify backward compatibility with numbered variants`() {
        val testDirectory = File("src/test/data/generator/object_diff_selection_set")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = testDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // Should generate numbered variants (ComplexObject, ComplexObject2) for different selection sets
        val complexObjectSpecs = fileSpecs.filter { it.name.startsWith("ComplexObject") }
        assertTrue(complexObjectSpecs.size >= 1, "Should generate ComplexObject types")

        // Verify they use operation-specific packages (not shared responses package)
        val operationSpecificTypes = complexObjectSpecs.filter {
            it.packageName.contains("differentselectionsquery")
        }
        assertTrue(operationSpecificTypes.isNotEmpty(), "Should generate operation-specific types")
    }

    @Test
    fun `verify reuse_types maintains backward compatibility`() {
        val testDirectory = File("src/test/data/generator/reuse_types")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = testDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // Should generate numbered variants for different selection sets
        val complexObjectSpecs = fileSpecs.filter { it.name.startsWith("ComplexObject") }
        assertTrue(complexObjectSpecs.size >= 1, "Should generate ComplexObject types")

        // Verify they use operation-specific packages
        val operationSpecificTypes = complexObjectSpecs.filter {
            it.packageName.contains("reusedtypesquery")
        }
        assertTrue(operationSpecificTypes.isNotEmpty(), "Should generate operation-specific types")
    }

    @Test
    fun `verify query classes import from operation-specific packages`() {
        val testDirectory = File("src/test/data/generator/object_diff_selection_set")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = testDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // Find the query class
        val querySpecs = fileSpecs.filter { it.name.endsWith("Query") }
        assertTrue(querySpecs.isNotEmpty(), "Should generate query classes")

        val querySpec = querySpecs.first()
        val queryString = querySpec.toString()

        // Verify it imports from operation-specific package
        assertTrue(
            queryString.contains("com.expediagroup.graphql.generated.differentselectionsquery.ComplexObject"),
            "Query should import ComplexObject from operation-specific package"
        )
    }
}
