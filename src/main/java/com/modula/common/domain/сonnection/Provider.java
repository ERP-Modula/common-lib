package com.modula.common.domain.сonnection;

import com.modula.common.domain.moduleconfiguration.AuthType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "description")
    private String description;

    @Column(name = "alert_notification", length = 20000)
    private String alertNotification;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProviderAdditionalParam> additionalParams = new ArrayList<>();

    @Column(name = "code_uri", nullable = false)
    private String codeUri; // Шаблон может быть с параметрами, например: "https://{domain}/oauth/authorize/"

    @Column(name = "auth_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthType authType;
}
