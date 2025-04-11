package com.modula.common.domain.workflow.execution.events;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class IntegrationTask {
    private UUID workflowInstanceId;
    private UUID stepId;
    private String actionName;
    private Map<String, String> params;
}
