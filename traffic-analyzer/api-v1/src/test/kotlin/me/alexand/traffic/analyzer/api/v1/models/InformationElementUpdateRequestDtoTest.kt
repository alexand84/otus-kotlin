package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InformationElementUpdateRequestDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes information element update request`() {
        val dto = InformationElementUpdateRequestDto(displayName = "Новое имя")

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, InformationElementUpdateRequestDto::class.java)

        assertEquals(dto, result)
    }
}
