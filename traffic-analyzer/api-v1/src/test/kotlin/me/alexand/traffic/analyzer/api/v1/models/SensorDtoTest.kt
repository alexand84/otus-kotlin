package me.alexand.traffic.analyzer.api.v1.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.OffsetDateTime
import java.util.*

class SensorDtoTest : AbstractDtoTest() {

    @Test
    fun `serializes sensor dto to json`() {
        val sensor = SensorDto(
            id = UUID.fromString("00000000-0000-0000-0000-000000000001"),
            name = "collector-1",
            currentIp = "192.168.1.45",
            observationDomainId = 42L,
            firstSeenAt = OffsetDateTime.parse("2026-11-27T10:38:05Z"),
            lastSeenAt = OffsetDateTime.parse("2026-11-27T11:00:00Z"),
            packetsReceived = 10L,
            isArchived = false,
            status = SensorStatus.ONLINE,
        )

        val json = mapper.writeValueAsString(sensor)

        assertTrue(json.contains("\"firstSeenAt\""))
        assertTrue(json.contains("\"status\""))
    }

    @Test
    fun `deserializes sensor dto from json`() {
        val json = """
            {
                "id": "00000000-0000-0000-0000-000000000001",
                "name": "collector-1",
                "currentIp": "192.168.1.45",
                "observationDomainId": 42,
                "firstSeenAt": "2026-11-27T10:38:05Z",
                "lastSeenAt": "2026-11-27T11:00:00Z",
                "packetsReceived": 10,
                "isArchived": false,
                "status": "ONLINE"
            }
        """.trimIndent()

        val sensor = mapper.readValue(json, SensorDto::class.java)

        assertEquals(UUID.fromString("00000000-0000-0000-0000-000000000001"), sensor.id)
        assertEquals("collector-1", sensor.name)
        assertEquals("192.168.1.45", sensor.currentIp)
        assertEquals(42L, sensor.observationDomainId)
        assertEquals(OffsetDateTime.parse("2026-11-27T10:38:05Z"), sensor.firstSeenAt)
        assertEquals(10L, sensor.packetsReceived)
        assertEquals(false, sensor.isArchived)
        assertEquals(SensorStatus.ONLINE, sensor.status)
    }
}
