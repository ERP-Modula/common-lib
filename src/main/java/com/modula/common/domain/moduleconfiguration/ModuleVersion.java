package com.modula.common.domain.moduleconfiguration;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class ModuleVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;

    private String version; // "1.2.3"
    @Enumerated(EnumType.STRING)
    private VersionStatus status;
    private String changelog;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDefault;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "configuration_id")
    private ModuleConfiguration configuration;
}
