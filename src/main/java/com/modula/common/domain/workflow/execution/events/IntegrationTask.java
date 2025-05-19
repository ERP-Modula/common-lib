package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.workflow.step.Step;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class IntegrationTask {
    private UUID workflowInstanceId;
    // TODO UUID instead of object
    private Step step;
    private String actionName;
    private Map<String, Object> params;
}
