package com.modula.common.domain.moduleconfiguration;

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
@Inheritance(strategy = InheritanceType.JOINED)
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
     * S3 object key for the module's logo (e.g., "logos/telegram/v1/icon.svg").
     * The actual URL should be resolved via CDN/object storage configuration.
     */
    private String logoKey;

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