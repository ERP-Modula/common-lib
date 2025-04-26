package com.modula.common.domain.workflow.execution.events;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class WebhookSubscribeIntegrationTask {
    private String triggerName;
    private Map<String, String> params;
}
