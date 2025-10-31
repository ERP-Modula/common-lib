package com.modula.common.dto.condition;

import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class ConditionGroup {

    private UUID id;
    private LogicalOperator operator; // AND или OR
    private List<Condition> conditions;
    private UUID nextStepId; // Шаг для перехода если группа условий истинна
}
