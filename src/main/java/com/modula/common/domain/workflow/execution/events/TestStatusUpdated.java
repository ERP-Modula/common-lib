package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestStatusUpdated {
    private UUID sessionId;
    @Enumerated(EnumType.STRING)
    private TestStatus status;
    private JsonNode payload;
}