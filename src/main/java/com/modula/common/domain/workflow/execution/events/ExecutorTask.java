package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.workflow.execution.IntegrationOutputObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecutorTask {
    private UUID workflowInstanceId;
    private Boolean isFirstStep;
    private IntegrationOutputObject integrationOutput;
}
