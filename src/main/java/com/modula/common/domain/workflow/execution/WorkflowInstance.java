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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private UUID workflowId;
    private UUID currentStepId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Step> steps;

    @ElementCollection
    private Map<String, IntegrationOutputObject> context;

    public UUID getFirstStepId() {
        Optional<Step> o = steps.stream().filter(s -> s.getPrevStepId().isEmpty()).findAny();
        return o.map(Step::getId).orElse(null);
    }
}
