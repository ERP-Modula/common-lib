package com.modula.common.domain.moduleconfiguration;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class ModuleAction {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String label;
    private String description;

    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputParametersInterface> outputOutputParametersInterfaces;

    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputParameter> inputParameters;

    @ManyToOne
    @JoinColumn(name = "module_configuration_id")
    private ModuleConfiguration module;

    // Getters and Setters
}