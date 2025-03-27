package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.scheduling.Trigger;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class ModuleConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String iconPath;
    private Boolean isPublic;
    private String theme;
    private String authorId;
    @Enumerated(EnumType.STRING)
    private AuthType authType;

    @ElementCollection
    private List<String> categories;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "module_api_handler_id")
    private List<ModuleAction> actions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "module_api_handler_id")
    private List<ModuleTrigger> triggers;
}