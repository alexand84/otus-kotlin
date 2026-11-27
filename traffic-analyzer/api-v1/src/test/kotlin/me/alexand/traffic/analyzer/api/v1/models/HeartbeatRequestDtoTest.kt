package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime

class HeartbeatRequestDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes and deserializes heartbeat request`() {
        val dto = HeartbeatRequestDto(
            sensors = listOf(
                SensorHeartbeatDto(
                    exporterIp = "192.168.1.45",
                    observationDomainId = 42L,
                    packetsReceived = 10L,
                    lastSeenAt = OffsetDateTime.parse("2026-11-27T11:00:00Z"),
                ),
            ),
        )

        val json = mapper.writeValueAsString(dto)
        val result = mapper.readValue(json, HeartbeatRequestDto::class.java)

        assertEquals(dto, result)
    }
}
