//package com.modula.common.domain.workflow.step.buildin.condition;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//import java.util.UUID;
//
//@Entity
//@Data
//public class ConditionGroup {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    @Enumerated(EnumType.STRING)
//    private LogicalOperator operator; // AND или OR
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "condition_group_id")
//    private List<Condition> conditions;
//
//    @Column(name = "next_step_id")
//    private UUID nextStepId; // Шаг для перехода если группа условий истинна
//}
