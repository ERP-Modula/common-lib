package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIAgentTestResultProduced {
    private String sessionId;
    private boolean isSuccess;
    private JsonNode payload;
}