package com.modula.common.domain.step;

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
    private String type;
    private String source;
    @ElementCollection
    private List<String> prevStepId;
    @ElementCollection
    private List<String> nextStepId;
    @Embedded
    private Metadata metadata;
    @ElementCollection
    private Map<String, String> parametersConfiguration;


    public void updateLocation(double newX, double newY) {
        Location newLocation = new Location(newX, newY);
        this.metadata = new Metadata(newLocation, this.metadata.getRestore());
    }

    public void updateRestore(Map<String, String> newParameters) {
        Restore newRestore = new Restore(newParameters);
        this.metadata = new Metadata(this.metadata.getLocation(), newRestore);
    }
}