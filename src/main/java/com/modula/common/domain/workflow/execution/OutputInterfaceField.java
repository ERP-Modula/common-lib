package com.modula.common.domain.workflow.execution;

import com.modula.common.domain.moduleconfiguration.InterfaceFieldType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class OutputInterfaceField {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    @Enumerated(EnumType.STRING)
    private InterfaceFieldType paramTypeEnum;
    private String value;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputInterfaceField> spec;
}
