package com.modula.common.domain.moduleconfiguration;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
public class ModuleTrigger {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;
    private String label;
    private String description;
    private String category;

    @ElementCollection
    private List<String> scopes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "output_parameters_interface_id")
    private List<OutputInterface> outputInterface;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "input_parameter_id")
    private List<InputParameter> inputParameters;
}