package com.modula.common.domain.workflow;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//TODO какие типы

@Embeddable
@Getter
@NoArgsConstructor
public class WorkflowType {
    private String type;

    public WorkflowType(String type){
        this.type = type;
    }
}
