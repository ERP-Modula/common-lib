package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.workflow.Workflow;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class WebhookSubscribeIntegrationTask {
    private UUID workflowId;
    private String triggerName;
    private Map<String, Object> webhookParams;
}
