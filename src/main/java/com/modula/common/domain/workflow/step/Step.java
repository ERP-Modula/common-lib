package com.modula.common.domain.workflow.step;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.modula.common.domain.billing.OperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class Step {
    @Id
    // @GeneratedValue(generator = "UUID")
    // Генерация на фронте
    private UUID id;
    @Enumerated(EnumType.STRING)
    private StepType type;
    private UUID parentModuleId;
    private int orderNum;
    private UUID handlerId;
    // TODO все на fk, сейчас google-docs:getFilesList (moduleConfig.id +
    // action/triiger.id)
    private String source;
    private Boolean isValid;
    @ElementCollection
    private List<UUID> prevStepId = new ArrayList<>();
    @ElementCollection
    private List<UUID> nextStepId = new ArrayList<>();
    @Embedded
    private StepMetadata metadata;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> parametersConfiguration;

    /**
     * Type of operation for billing purposes.
     * Determines the cost in tokens for executing this step.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_type_id")
    private OperationType operationType;

    @Transient
    public StepSource getParsedSource() {
        if (this.source == null) {
            return null;
        }
        return new StepSource(this.source);
    }

    public void addNextStep(UUID newNextStepId) {
        nextStepId.add(newNextStepId);
    }

    public void removeNextStep(UUID removedNextStepId) {
        nextStepId.remove(removedNextStepId);
    }

    public void addPrevStep(UUID newPrevStepId) {
        prevStepId.add(newPrevStepId);
    }

    public void removePrevStep(UUID removedPrevStepId) {
        prevStepId.remove(removedPrevStepId);
    }

    public void updateLocation(double newX, double newY) {
        Location newLocation = new Location(newX, newY);
        this.metadata = new StepMetadata(newLocation);
    }

    public void updateRestore(Map<String, String> newParameters) {
        Restore newRestore = new Restore(newParameters);
        this.metadata = new StepMetadata(this.metadata.getLocation());
    }
}