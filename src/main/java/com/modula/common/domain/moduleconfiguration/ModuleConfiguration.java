package com.modula.common.domain.moduleconfiguration;

import com.modula.common.domain.сonnection.Provider;
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
    // Базовая часть всего open Api. Может быть шаблоном, с использованием переменных из connection.
    // Например, https://**put_your_bitrix24_address**/rest, а /tasks.task.add это ednpoind конкретного action
    private String restApiBaseUrl;
    private String webhookBaseUrl;
    @Enumerated(EnumType.STRING)
    private AuthType authType;

//  TODO Убрать из реста. приходят вся инфа о подключениях :) взломают
    @ManyToOne(optional = false)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @ElementCollection
    private List<String> categories;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuleAction> actions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuleTrigger> triggers;
}