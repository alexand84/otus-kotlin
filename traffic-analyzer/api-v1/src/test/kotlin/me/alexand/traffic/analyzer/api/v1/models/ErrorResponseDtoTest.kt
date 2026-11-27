package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ErrorResponseDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes error response`() {
        val dto = ErrorResponseDto(code = "NOT_FOUND", message = "Not found")

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, ErrorResponseDto::class.java)

        assertEquals(dto, result)
    }
}
