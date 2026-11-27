package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InformationElementDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes information element`() {
        val dto = InformationElementDto(
            id = 1L,
            enterpriseId = 0L,
            elementId = 1,
            fieldName = "src_ip",
            displayName = "IP отправителя",
            dataType = DataType.IPV4_ADDRESS,
            role = ElementRole.KEY,
            isSystem = false,
        )

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, InformationElementDto::class.java)

        assertEquals(dto, result)
    }
}
