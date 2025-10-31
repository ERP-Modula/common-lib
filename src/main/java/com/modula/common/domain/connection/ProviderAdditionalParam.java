package com.modula.common.domain.connection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Represents an additional parameter that a user must provide
 * when configuring a connection to a specific {@link Provider}.
 * Useful for provider-specific fields such as "domain", "instance ID", etc.
 */
@Data
@Entity
public class ProviderAdditionalParam {
    /**
     * Unique identifier of the additional parameter.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Machine-readable key used in the system (e.g., "domain").
     */
    @Column(name = "param_key", nullable = false)
    private String key;

    /**
     * Human-readable label shown in UI forms (e.g., "Bitrix24 Domain").
     */
    @Column(name = "label", nullable = false)
    private String label;

    /**
     * Optional description or help text for the user (e.g., "Enter your Bitrix24
     * subdomain").
     */
    @Column(name = "description")
    private String description;
    /**
     * Optional tooltip text for the user (e.g., "Enter your Bitrix24 subdomain").
     */
    @Column(name = "help_tooltip_text")
    private String helpTooltipText;

    /**
     * Optional URL to a help page for the user (e.g., "https://example.com/help").
     */
    @Column(name = "help_url")
    private String helpUrl;

    /**
     * The associated provider that this parameter belongs to.
     * Ignored in JSON to avoid recursion or exposing sensitive configuration.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;
}
