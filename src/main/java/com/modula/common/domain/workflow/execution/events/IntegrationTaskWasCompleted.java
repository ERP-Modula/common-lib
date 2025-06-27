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
public class IntegrationTaskWasCompleted {
    private UUID stepId;
    @Nullable
    private UUID workflowInstanceId;
    private Boolean isFirstStep;
    private Boolean isTestExecution;
    @Nullable
    private String testWebsocketSessionId;
    private JsonNode outputTaskPayload;
//    private IntegrationOutputObject integrationOutput;
}