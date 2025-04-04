package com.modula.common.domain.workflow.step;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
public class Step {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Enumerated(EnumType.STRING)
    private StepType type;


//  TODO все на fk, сейчас google-docs:getFilesList (moduleConfig.id + action/triiger.id)
    private String source;
    @ElementCollection
    private List<String> prevStepId;
    @ElementCollection
    private List<String> nextStepId;
    @Embedded
    private StepMetadata metadata;
    @ElementCollection
    private Map<String, String> parametersConfiguration;

    public void updateLocation(double newX, double newY) {
        Location newLocation = new Location(newX, newY);
        this.metadata = new StepMetadata(newLocation);
    }

    public void updateRestore(Map<String, String> newParameters) {
        Restore newRestore = new Restore(newParameters);
        this.metadata = new StepMetadata(this.metadata.getLocation());
    }
}