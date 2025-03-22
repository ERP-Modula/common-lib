package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class NestedFieldOption {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String label;
    private String value;

    @Enumerated(EnumType.STRING)
    private ParamTypeEnum type;

    private boolean isDefault;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "input_parameter_id")
    private List<InputParameter> nested;
}