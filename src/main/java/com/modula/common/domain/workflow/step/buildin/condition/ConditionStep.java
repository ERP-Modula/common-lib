//package com.modula.common.domain.workflow.step.buildin.condition;
//
//import com.modula.common.domain.workflow.step.Step;
//import com.modula.common.domain.workflow.step.StepType;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//
//import java.util.List;
//import java.util.UUID;
//
//@Entity
//@Data
//@EqualsAndHashCode(callSuper = true)
//public class ConditionStep extends Step {
//
//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "condition_step_id")
//    private List<ConditionGroup> conditionGroups;
//
//    @Column(name = "default_next_step_id")
//    private UUID defaultNextStepId; // Шаг по умолчанию если ни одно условие не выполнилось
//
//    public ConditionStep() {
//        this.setType(StepType.CONDITION);
//    }
//}