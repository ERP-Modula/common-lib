package com.modula.common.domain.workflow.execution;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WorkflowInstanceStatus {
    FAILED("Failed"),
    COMPLETED("Completed"),
    PROCESSING("Processing");
    private final String value;

    @Override
    public String toString() {
        return this.value;
    }
}
