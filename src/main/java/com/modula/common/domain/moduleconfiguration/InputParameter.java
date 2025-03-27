package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class InputParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String label;
    private Boolean required;
    private String help;

    @Enumerated(EnumType.STRING)
    private ParamType type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "nested_field_option_id")
    private List<NestedFieldOption> options;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "parent_input_parameter_id")
    private List<InputParameter> spec;
}