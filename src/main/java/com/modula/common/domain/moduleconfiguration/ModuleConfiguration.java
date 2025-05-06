package com.modula.common.domain.moduleconfiguration;

import com.modula.common.domain.connection.Provider;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * Represents the configuration metadata for an external integration module.
 * This configuration includes display information, API access points, authentication type,
 * and associated actions and triggers.
 */
@Entity
@Data
@Table(
        name = "module_configuration",
        uniqueConstraints = @UniqueConstraint(columnNames = "name")
)
public class ModuleConfiguration {

    /**
     * Unique identifier for the module configuration.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Unique system name for the module (e.g., "bitrix", "google").
     */
    private String name;

    /**
     * Human-readable label (e.g., "Bitrix24 CRM").
     */
    private String label;

    /**
     * Detailed description of the module.
     */
    private String description;

    /**
     * Path to the module's icon (e.g., "/icons/bitrix.png").
     */
    private String iconPath;

    /**
     * Indicates if the module is publicly visible.
     */
    private Boolean isPublic;

    /**
     * Theme color of the module (e.g., "blue", "#FF5733").
     */
    private String theme;

    /**
     * Identifier of the author or system that created the module.
     */
    private String authorId;

    /**
     * Base URL for accessing the open REST API.
     * This may contain template variables from the connection.
     * Example: "https://<bitrix_domain>/rest"
     */
    // Базовая часть всего open Api. Может быть шаблоном, с использованием переменных из connection.
    // Например, https://**put_your_bitrix24_address**/rest, а /tasks.task.add это ednpoind конкретного action
    private String restApiBaseUrl;

    /**
     * Base URL for the webhook API.
     * This may also contain template variables from the connection.
     * Example: https://<bitrix_domain>/webhooks
     */
    private String webhookBaseUrl;

    /**
     * Authentication type used by the module (e.g., OAUTH2, API_KEY).
     */
    @Enumerated(EnumType.STRING)
    private AuthType authType;

    /**
     * Reference to the provider associated with this module.
     */
//  TODO Убрать из реста. приходят вся инфа о подключениях :) взломают
    @ManyToOne(optional = false)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    /**
     * Categories to which the module belongs (e.g., ["crm", "sales"]).
     */
    @ElementCollection
    private List<String> categories;

    /**
     * List of available API actions provided by the module.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuleAction> actions;

    /**
     * List of available triggers (webhooks) provided by the module.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ModuleTrigger> triggers;
}