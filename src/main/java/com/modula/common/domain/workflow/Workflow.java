package com.modula.common.domain.workflow;


import com.modula.common.domain.workflow.step.Step;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor
public class Workflow {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String description;
    private boolean enable = false;
    @Embedded
    private SchedulerSettings schedulerSettings;
    private boolean isArchived = false;
    @ElementCollection
//    TODO должны быть ссыылки на ModulesConfiguration
    private List<String> usedModules = new ArrayList<>();
    private ZonedDateTime created;
    private String createdByUserId;
    private ZonedDateTime lastEdit;
    private String updatedByUserId;
    private int executionCount;
    private int currInstancesCount;
    private ZonedDateTime lastExecution;
    //    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//    @JoinColumn(name = "workflow_id")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "workflow_step_mapping",
            joinColumns = @JoinColumn(name = "workflow_id"),
            inverseJoinColumns = @JoinColumn(name = "step_id")
    )
    private final List<Step> steps = new ArrayList<>();

    //    TODO доделать остальные поля
    public Workflow(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = ZonedDateTime.now();
        this.lastEdit = ZonedDateTime.now();
    }

    public void addStep(Step step) {
        if (steps.stream().anyMatch(s -> s.getId().equals(step.getId()))) {
            throw new IllegalArgumentException("Step with this ID already exists");
        }
        steps.add(step);
    }


    public void updateStep(UUID stepId, Step updatedStep) {
        Step existingStep = steps.stream()
                .filter(s -> s.getId().equals(stepId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Step not found"));
        existingStep.setType(updatedStep.getType());
        existingStep.setSource(updatedStep.getSource());
        existingStep.setPrevStepId(updatedStep.getPrevStepId());
        existingStep.setNextStepId(updatedStep.getNextStepId());
        existingStep.setMetadata(updatedStep.getMetadata());
        existingStep.setParametersConfiguration(updatedStep.getParametersConfiguration());
    }

    public void removeStep(UUID stepId) {
        steps.removeIf(s -> s.getId().equals(stepId));
    }
}