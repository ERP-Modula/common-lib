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
    private List<WorkflowInstance> sub;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    @JoinTable(name = "workflow_instance_step_mapping", joinColumns = @JoinColumn(name = "workflow_instance_id"), inverseJoinColumns = @JoinColumn(name = "step_id"))
    private List<Step> steps;

    @OneToMany(
            cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST},
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "workflow_instance_id")
    private List<IntegrationOutputObject> context;

    public UUID getFirstStepId() {
        Optional<Step> o = steps.stream().filter(s -> s.getPrevStepId().isEmpty()).findAny();
        return o.map(Step::getId).orElse(null);
    }
}
