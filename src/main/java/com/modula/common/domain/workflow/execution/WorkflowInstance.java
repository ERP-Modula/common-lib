package com.modula.common.domain.workflow.execution;

import com.modula.common.domain.workflow.step.Step;
import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_instance_id")
    private List<WorkflowInstance> sub = new java.util.ArrayList<>();

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
                .filter(s -> s.getPrevStepId() == null)
                .findAny()
                .map(Step::getId)
                .orElse(null);
    }

    public List<WorkflowInstance> getSubSafe() {
        if (sub == null) sub = new java.util.ArrayList<>();
        return sub;
    }
    public void addSub(WorkflowInstance child) {
        getSubSafe().add(child);
    }
}