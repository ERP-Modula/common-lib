package com.modula.common.domain.workflow.execution.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StartSubprocessRequested {
    private UUID correlationId;
    private UUID workflowToExecuteId;
    private Map<String, Object> inputParameters;
}