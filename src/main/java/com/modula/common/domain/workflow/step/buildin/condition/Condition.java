//package com.modula.common.domain.workflow.step.buildin.condition;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.UUID;
//
//@Entity
//@Data
//public class Condition {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "type", column = @Column(name = "left_operand_type")),
//            @AttributeOverride(name = "value", column = @Column(name = "left_operand_value")),
//            @AttributeOverride(name = "dataType", column = @Column(name = "left_data_type"))
//    })
//    private Operand leftOperand;
//
//    @Enumerated(EnumType.STRING)
//    private ComparisonOperator operator;
//
//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name = "type", column = @Column(name = "right_operand_type")),
//            @AttributeOverride(name = "value", column = @Column(name = "right_operand_value")),
//            @AttributeOverride(name = "dataType", column = @Column(name = "right_data_type"))
//    })
//
//    private Operand rightOperand;
//}
