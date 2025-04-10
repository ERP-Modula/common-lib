package com.modula.common.domain.moduleconfiguration.provider;

import com.modula.common.domain.moduleconfiguration.AuthType;
import com.modula.common.domain.moduleconfiguration.ModuleConfiguration;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "provider")
@Inheritance(strategy = InheritanceType.JOINED)
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "auth_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthType authType;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
    private List<ModuleConfiguration> moduleConfigurations;
}
