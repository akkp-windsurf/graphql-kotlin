package com.expediagroup.graphql.plugin.client.generator

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SharedResponseTypesIT {

    @Test
    fun `verify shared response types eliminate duplicates in object_diff_selection_set`() {
        val testDirectory = File("src/test/data/generator/object_diff_selection_set")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = testDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // Should generate fewer files due to shared response types
        // Verify that ComplexObject is in shared responses package
        val complexObjectSpecs = fileSpecs.filter { it.name == "ComplexObject" }
        assertEquals(1, complexObjectSpecs.size, "Should generate only one ComplexObject type")

        val complexObjectSpec = complexObjectSpecs.first()
        assertEquals("com.expediagroup.graphql.generated.responses", complexObjectSpec.packageName)

        // Verify the shared ComplexObject has all merged fields
        val complexObjectString = complexObjectSpec.toString()
        assertTrue(complexObjectString.contains("val id: Int"), "Should contain id field")
        assertTrue(complexObjectString.contains("val name: String"), "Should contain name field")
        assertTrue(complexObjectString.contains("val details: DetailsObject"), "Should contain details field")
    }

    @Test
    fun `verify shared response types eliminate duplicates in reuse_types`() {
        val testDirectory = File("src/test/data/generator/reuse_types")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = testDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // Should generate only one ComplexObject instead of ComplexObject, ComplexObject2, ComplexObject3
        val complexObjectSpecs = fileSpecs.filter { it.name.startsWith("ComplexObject") }
        assertEquals(1, complexObjectSpecs.size, "Should generate only one ComplexObject type instead of 3 variants")

        val complexObjectSpec = complexObjectSpecs.first()
        assertEquals("ComplexObject", complexObjectSpec.name)
        assertEquals("com.expediagroup.graphql.generated.responses", complexObjectSpec.packageName)
    }

    @Test
    fun `verify SelectionSet merging handles nested fields correctly`() {
        // Test that nested selection sets are properly merged
        val testDirectory = File("src/test/data/generator/object_diff_selection_set")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = testDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // Find the DetailsObject type
        val detailsObjectSpecs = fileSpecs.filter { it.name.startsWith("DetailsObject") }
        assertTrue(detailsObjectSpecs.isNotEmpty(), "Should generate DetailsObject types")

        // Verify DetailsObject is also in shared responses package
        val sharedDetailsObjects = detailsObjectSpecs.filter {
            it.packageName == "com.expediagroup.graphql.generated.responses"
        }
        assertTrue(sharedDetailsObjects.isNotEmpty(), "DetailsObject should also be in shared responses package")
    }

    @Test
    fun `verify shared response types reduce total generated files`() {
        val objectDiffDirectory = File("src/test/data/generator/object_diff_selection_set")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = objectDiffDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // With shared response types, we should generate fewer files than the old approach
        // The old approach would generate ComplexObject and ComplexObject2 (2 types)
        // The new approach should generate only 1 ComplexObject in shared responses package
        val responseTypes = fileSpecs.filter {
            it.packageName == "com.expediagroup.graphql.generated.responses"
        }
        assertTrue(responseTypes.isNotEmpty(), "Should generate shared response types")

        // Verify no duplicate ComplexObject types exist
        val allComplexObjects = fileSpecs.filter { it.name.contains("ComplexObject") }
        assertTrue(allComplexObjects.size <= 1, "Should not generate duplicate ComplexObject types")
    }

    @Test
    fun `verify query classes import from shared responses package`() {
        val testDirectory = File("src/test/data/generator/object_diff_selection_set")
        val generator = GraphQLClientGenerator(TEST_SCHEMA_PATH, defaultConfig)
        val queries = testDirectory.walkTopDown().filter { it.name.endsWith(".graphql") }.toList()

        val fileSpecs = generator.generate(queries)

        // Find the query class
        val querySpecs = fileSpecs.filter { it.name.endsWith("Query") }
        assertTrue(querySpecs.isNotEmpty(), "Should generate query classes")

        val querySpec = querySpecs.first()
        val queryString = querySpec.toString()

        // Verify it imports from shared responses package
        assertTrue(
            queryString.contains("com.expediagroup.graphql.generated.responses.ComplexObject"),
            "Query should import ComplexObject from shared responses package"
        )
    }
}
