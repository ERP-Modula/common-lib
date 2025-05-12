package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.workflow.Workflow;
import com.modula.common.domain.workflow.step.Step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivateWorkflowTask {
    private Workflow workflow;
    private boolean isActive;
}
