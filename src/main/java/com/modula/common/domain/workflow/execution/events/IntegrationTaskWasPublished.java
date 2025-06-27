package com.modula.common.domain.workflow.execution.events;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class IntegrationTaskWasPublished {
    private UUID stepId;
    @Nullable
    private UUID workflowInstanceId;
    private Boolean isTestExecution;
    @Nullable
    private String testWebsocketSessionId;
    private String actionName;
    private Map<String, Object> params;
}
