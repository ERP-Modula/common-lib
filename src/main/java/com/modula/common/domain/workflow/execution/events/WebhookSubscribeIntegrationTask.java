package com.modula.common.domain.workflow.execution.events;

import lombok.Data;

import java.util.Map;

@Data
public class WebhookSubscribeIntegrationTask {
    private String triggerName;
    private Map<String, Object> webhookParams;
}
