package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.workflow.Workflow;
import lombok.Data;

@Data
public class WebhookSubscribeIntegrationTask {
    private Workflow workflow;
}
