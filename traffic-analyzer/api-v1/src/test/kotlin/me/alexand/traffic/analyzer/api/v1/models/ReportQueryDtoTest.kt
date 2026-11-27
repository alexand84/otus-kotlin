package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class ReportQueryDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes report query`() {
        val dto = ReportQueryDto(
            from = OffsetDateTime.parse("2026-11-27T10:00:00Z"),
            to = OffsetDateTime.parse("2026-11-27T11:00:00Z"),
            metrics = listOf(ReportMetricDto(field = "src_ip", aggregation = AggregationType.SUM)),
        )

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, ReportQueryDto::class.java)

        assertEquals(dto, result)
    }
}
