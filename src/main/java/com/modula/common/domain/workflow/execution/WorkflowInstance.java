package com.modula.common.domain.workflow.execution;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.modula.common.domain.workflow.step.Step;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Entity
public class WorkflowInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID workflowId;
    private UUID currentStepId;
    private Boolean isRoot;
    private Timestamp startTime;
    private Timestamp endTime;
    private Boolean isDone = false;

    @Enumerated(EnumType.STRING)
    private WorkflowInstanceStatus status;

    @OneToMany(
            mappedBy = "parent",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<WorkflowInstance> sub = new java.util.ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_instance_id")
    @JsonBackReference
    @ToString.Exclude
    private WorkflowInstance parent;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(
            name = "workflow_instance_step_mapping",
            joinColumns = @JoinColumn(name = "workflow_instance_id"),
            inverseJoinColumns = @JoinColumn(name = "step_id")
    )
    private List<Step> steps = new java.util.ArrayList<>();

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "workflow_instance_id")
    private List<IntegrationOutputObject> context = new java.util.ArrayList<>();

    public UUID getFirstStepId() {
        return steps.stream()
                .filter(s -> s.getOrderNum() == 1)
                .findFirst()
                .map(Step::getId)
                .orElse(null);
    }

    public List<WorkflowInstance> getSubSafe() {
        if (sub == null) sub = new java.util.ArrayList<>();
        return sub;
    }
    public void addSub(WorkflowInstance child) {
        getSubSafe().add(child);
        child.setParent(this);
    }
}