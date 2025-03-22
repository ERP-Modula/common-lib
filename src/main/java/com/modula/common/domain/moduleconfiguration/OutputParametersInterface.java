package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class OutputParametersInterface {
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    private String name;
    @Enumerated(EnumType.STRING)
    private ParamTypeEnum paramTypeEnum;
    private String label;
    private boolean time;

    @OneToMany(mappedBy = "interfaceEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputParametersInterface> spec;
}