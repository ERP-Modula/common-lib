package com.modula.common.domain.moduleconfiguration;


import com.modula.common.utils.ActionHttpMethodType;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class ModuleAction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String label;
    private String description;
    private String category;
//    Добавочная часть к ModuleConfiguration.getRestApiBaseUrl() для вызова конкретного endpoint
    private String endpointUrl;
    @Enumerated(EnumType.STRING)
    private ActionHttpMethodType methodType;

    @ElementCollection
    private List<String> scopes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputInterface> outputInterface;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputParameter> inputParameters;
}