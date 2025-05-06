package com.modula.common.domain.connection.impl;

import com.modula.common.domain.connection.ExternalConnection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents an external connection that uses a static API key for authentication.
 * This connection type is commonly used in simpler or legacy APIs.
 * Extends {@link ExternalConnection}.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "api_key_external_connection")
public class ApiKeyExternalConnection extends ExternalConnection {
    /**
     * The API key used to authenticate requests to the external system.
     * This is a sensitive credential and should never be exposed to clients.
     */
    @Column(name = "api_key", nullable = false)
    private String apiKey;
}
