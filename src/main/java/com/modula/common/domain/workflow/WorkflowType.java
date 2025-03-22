package com.modula.common.domain.workflow;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
