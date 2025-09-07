package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneTimeSubscriptionStatusUpdated {
    private UUID workflowId;
    private String websocketSessionId;
    private Map<String, Object> subscriptionParams;
    private String status;
    private int initialDuration;
    private JsonNode webhookPayload;
}