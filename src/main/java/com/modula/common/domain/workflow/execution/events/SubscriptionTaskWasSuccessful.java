package com.modula.common.domain.workflow.execution.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionTaskWasSuccessful {
    private UUID workflowId;
    private String moduleName;
    private String triggerName;
    private TriggerSubscriptionAction action;
}