package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import com.modula.common.domain.workflow.Workflow;
import lombok.Data;

@Data
public class HandleWebhookInitWorkflowEventTask {
    private boolean isOneTimeRun;
    private Workflow workflow;
    private JsonNode webhookEventOutputPayload;
}