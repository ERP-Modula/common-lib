package com.modula.common.domain.moduleconfiguration;


import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class ModuleTrigger {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String label;
    private String description;

    @OneToMany(mappedBy = "trigger", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "module_id")
    private List<OutputParametersInterface> interfaces;

    @OneToMany(mappedBy = "trigger", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputParameter> parameters;
}