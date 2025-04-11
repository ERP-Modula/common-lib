package com.modula.common.domain.workflow.execution;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class IntegrationOutputObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String moduleName;
    private UUID stepId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputInterfaceField> fields;
}
