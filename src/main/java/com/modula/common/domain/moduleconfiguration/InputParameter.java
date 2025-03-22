package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class InputParameter {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String label;
    private boolean required;
    private String help;

    @Enumerated(EnumType.STRING)
    private ParamTypeEnum type;

    @OneToMany(mappedBy = "parameter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NestedFieldOption> options;
}