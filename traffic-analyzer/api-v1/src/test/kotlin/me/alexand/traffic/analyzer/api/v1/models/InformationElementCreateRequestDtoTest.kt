package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InformationElementCreateRequestDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes information element create request`() {
        val dto = InformationElementCreateRequestDto(
            enterpriseId = 0L,
            elementId = 1,
            fieldName = "src_ip",
            displayName = "IP отправителя",
            dataType = DataType.IPV4_ADDRESS,
            role = ElementRole.KEY,
        )

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, InformationElementCreateRequestDto::class.java)

        assertEquals(dto, result)
    }
}
