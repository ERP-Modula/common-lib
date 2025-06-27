package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.moduleconfiguration.ModuleTrigger;
import com.modula.common.domain.workflow.Workflow;
import lombok.Data;

import java.util.Map;

@Data
public class UnsubscribeWorkflowFromWebhookTask {
    private Workflow workflow;
    private String webhookTriggerName;
    private Map<String, Object> webhookParams;
}
