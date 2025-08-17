package com.modula.common.domain.workflow.execution.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneTimeSubscriptionStatusUpdated {
    private UUID workflowId;
    private String websocketSessionId;
    private String status;
    private int initialDuration;
}