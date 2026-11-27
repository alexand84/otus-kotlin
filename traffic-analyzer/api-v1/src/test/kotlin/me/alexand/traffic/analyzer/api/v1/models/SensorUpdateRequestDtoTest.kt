package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SensorUpdateRequestDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes sensor update request`() {
        val dto = SensorUpdateRequestDto(name = "collector-2")

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, SensorUpdateRequestDto::class.java)

        assertEquals(dto, result)
    }
}
