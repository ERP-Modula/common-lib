package com.modula.common.domain.workflow.execution.events;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IntegrationTaskWasFailed {
    private Boolean isTestExecution;
    @Nullable
    private UUID workflowInstanceId;
    @Nullable
    private String testWebsocketSessionId;
    private JsonNode errorMessage;
}
