package com.modula.common.dto.condition;

import lombok.Data;

import java.util.UUID;

@Data
public class Condition {

    private UUID id;

    private Operand leftOperand;

    private ComparisonOperator operator;

    private Operand rightOperand;
}
