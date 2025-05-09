package com.modula.common.domain.connection;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents a user's external connection to a specific {@link Provider},
 * such as an OAuth2 session or API key configuration.
 * Stores associated metadata like additional parameters, ownership, and status.
 */
@Data
@Entity
@Table(name = "external_connection")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class ExternalConnection {

    /**
     * Unique identifier for the connection instance.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Optional user-defined name for this connection (e.g., "My Bitrix24").
     */
    @Column(name = "name")
    private String name;

    /**
     * Additional connection parameters provided by the user at connection time.
     * Keys usually match {@link ProviderAdditionalParam} keys.
     */
    @ElementCollection
    private Map<String, String> connectionAdditionalParams = new HashMap<>();

    /**
     * The provider to which this connection is bound (e.g., Bitrix24, Google).
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    /**
     * ID of the user who owns this connection.
     */
    @Column(name = "user_id")
    private UUID userId;

    /**
     * Whether this connection is currently active or not.
     */
    @Column(name = "connected")
    private Boolean connected;
}
