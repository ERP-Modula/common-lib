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
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String iconPath;
    private boolean isPublic;
    private String theme;

    @ElementCollection
    private List<String> categories;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "module_api_handler_id")
    private List<ModuleAction> actions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "module_api_handler_id")
    private List<Trigger> triggers;
}
