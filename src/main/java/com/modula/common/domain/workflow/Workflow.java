package com.modula.common.domain.workflow;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modula.common.domain.workflow.step.Edge;
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
    private boolean isActive = false;
    @Embedded
    private SchedulerSettings schedulerSettings;
//    Параметр для polling триггеров, которым необходима дата забора новых объектов
//    Например, GET https://www.googleapis.com/drive/v3/files?
//  q=mimeType='application/vnd.google-apps.form' and createdTime > '2024-05-20T00:00:00' (lastPollingTime)

    private ZonedDateTime lastPollingTime;
    private boolean isArchived = false;
    @ElementCollection
//    TODO должны быть ссыылки на ModulesConfiguration
    private List<String> usedModules = new ArrayList<>();
    private ZonedDateTime created;
    private String createdByUserId;
    private ZonedDateTime lastEdit;
    private String updatedByUserId;
    private int executionCount;
    private ZonedDateTime lastExecution;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "workflow_step_mapping",
            joinColumns = @JoinColumn(name = "workflow_id"),
            inverseJoinColumns = @JoinColumn(name = "step_id")
    )
    private final List<Step> steps = new ArrayList<>();
    //  For frontend
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "workflow_edge_mapping",
            joinColumns = @JoinColumn(name = "workflow_id"),
            inverseJoinColumns = @JoinColumn(name = "edge_id")
    )
    private List<Edge> edges;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "workflow_id")
    private final List<WorkflowTriggerSubscription> triggerSubscriptions = new ArrayList<>();

    //    TODO доделать остальные поля
    public Workflow(String name, String description) {
        this.name = name;
        this.description = description;
        this.created = ZonedDateTime.now();
        this.lastEdit = ZonedDateTime.now();
    }

    public void subscribeWorkflowOnWebhook(WorkflowTriggerSubscription workflowTriggerSubscription) {
        triggerSubscriptions.add(workflowTriggerSubscription);
    }

    public void unsubscribeWorkflowOnWebhook(WorkflowTriggerSubscription workflowTriggerSubscription) {
        triggerSubscriptions.remove(workflowTriggerSubscription);
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

    public void addNewEdge(Edge edge) {
        edges.add(edge);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setLastExecution(ZonedDateTime lastExecution) {
        this.lastExecution = lastExecution;
    }
}