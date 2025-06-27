package com.modula.common.domain.workflow.execution.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TriggerTestRequestPublished {
    private UUID stepId;
    private UUID sessionId;
    private Map<String, Object> triggerParams;
}
