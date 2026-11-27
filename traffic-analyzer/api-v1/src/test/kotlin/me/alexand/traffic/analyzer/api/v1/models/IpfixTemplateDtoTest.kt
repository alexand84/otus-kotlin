package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime
import java.util.*

class IpfixTemplateDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes ipfix template`() {
        val dto = IpfixTemplateDto(
            id = 1L,
            sensorId = UUID.fromString("00000000-0000-0000-0000-000000000002"),
            observationDomainId = 42L,
            templateId = 256,
            updatedAt = OffsetDateTime.parse("2026-11-27T10:38:05Z"),
            fields = listOf(
                TemplateFieldDto(
                    id = 1L,
                    templateId = 256L,
                    position = 0,
                    enterpriseId = 0L,
                    elementId = 1,
                    length = 4,
                ),
            ),
        )

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, IpfixTemplateDto::class.java)

        assertEquals(dto, result)
    }
}
