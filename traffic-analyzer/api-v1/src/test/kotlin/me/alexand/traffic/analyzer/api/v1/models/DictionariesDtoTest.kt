package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DictionariesDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes dictionaries`() {
        val dto = DictionariesDto(
            dataTypes = listOf(DataType.IPV4_ADDRESS),
            roles = listOf(ElementRole.KEY),
            aggregations = listOf(AggregationType.SUM),
            filterOperators = listOf(FilterOperator.EQ),
        )

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, DictionariesDto::class.java)

        assertEquals(dto, result)
    }
}
