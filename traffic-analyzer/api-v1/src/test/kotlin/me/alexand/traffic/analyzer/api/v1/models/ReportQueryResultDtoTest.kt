package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReportQueryResultDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes report query result`() {
        val dto = ReportQueryResultDto(
            columns = listOf(ReportColumnDto(name = "src_ip", dataType = DataType.IPV4_ADDRESS)),
            rows = listOf(mapOf("src_ip" to "192.168.1.45")),
            totalRows = 1L,
            executionTimeMs = 5L,
        )

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, ReportQueryResultDto::class.java)

        assertEquals(dto, result)
    }
}
