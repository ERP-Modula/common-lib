package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ElementCollection
    private List<String> categories;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuleAction> actions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuleTrigger> triggers;
}