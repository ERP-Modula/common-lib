package com.modula.common.domain.workflow.execution;

import com.modula.common.domain.workflow.step.Step;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "workflow_instance_id")
    private List<Step> steps;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IntegrationOutputObject> context;

    public UUID getFirstStepId() {
        Optional<Step> o = steps.stream().filter(s -> s.getPrevStepId().isEmpty()).findAny();
        return o.map(Step::getId).orElse(null);
    }
}
