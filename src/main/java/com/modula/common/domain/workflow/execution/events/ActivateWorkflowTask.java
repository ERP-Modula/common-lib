package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.workflow.Workflow;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivateWorkflowTask {
    private Workflow workflow;
}
