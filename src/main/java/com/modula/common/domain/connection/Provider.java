package com.modula.common.domain.connection;

import com.modula.common.domain.moduleconfiguration.AuthType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents an external service provider (e.g., Bitrix24, Google) that can be connected
 * via OAuth2, API keys, or other authentication mechanisms.

 * Each provider includes metadata for display, authorization configuration, and
 * optional UI hints or alerts to guide users through the integration process.
 */
@Data
@Entity
@Table(name = "provider")
@Inheritance(strategy = InheritanceType.JOINED)
public class Provider {

    /**
     * Unique identifier of the provider.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Internal system name of the provider (e.g., "bitrix", "google").
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Human-readable display name (e.g., "Bitrix24", "Google Docs").
     */
    @Column(name = "label", nullable = false)
    private String label;

    /**
     * Description of the provider shown to users, including integration instructions.
     */
    @Column(name = "description")
    private String description;

    /**
     * Alert message shown to users before connecting the provider (e.g., "Add app to Bitrix24 first").
     */
    @Column(name = "alert_notification", length = 20000)
    private String alertNotification;

    /**
     * List of additional connection parameters defined for this provider.
     * These parameters can be dynamically rendered on the connection form.
     */
    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProviderAdditionalParam> additionalParams = new ArrayList<>();

    /**
     * URL template used to start the authorization process.
     * May include placeholders like {domain}, {client_id}, etc.
     * Example: "https://{domain}/oauth/authorize"
     */
    @Column(name = "code_uri", nullable = false)
    private String codeUri;

    /**
     * Authentication type supported by the provider (e.g., OAUTH2, BASIC, API_KEY).
     */
    @Column(name = "auth_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthType authType;
}
