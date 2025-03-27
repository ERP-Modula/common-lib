package com.modula.common.domain.moduleconfiguration;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
@Entity
public class ModuleTrigger {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private TriggerType type;
    private String name;
    private String label;
    private String description;
    private String category;
    private String endpointUrl;
    @Embedded
    private TriggerSettings triggerSettings;
    private Map<String, Object> settings;

    @ElementCollection
    private List<String> scopes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "output_parameters_interface_id")
    private List<OutputInterface> outputInterface;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "input_parameter_id")
    private List<InputParameter> inputParameters;
}