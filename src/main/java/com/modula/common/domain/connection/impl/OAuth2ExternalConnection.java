package com.modula.common.domain.connection.impl;

import com.modula.common.domain.connection.ExternalConnection;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.Set;

/**
 * Represents an OAuth2-based external connection for a specific user and provider.
 * Stores access credentials, expiration, scopes, and token metadata.
 * This entity extends {@link ExternalConnection}.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oauth2_external_connection")
public class OAuth2ExternalConnection extends ExternalConnection {
    /**
     * The OAuth2 access token used for API authorization.
     */
    @Column(name = "access_token")
    private String accessToken;

    /**
     * The instant when the access token expires.
     */
    @Column(name = "expires_at")
    private Instant expiresAt;

    /**
     * The refresh token used to obtain a new access token after expiration.
     * May be optional depending on provider's settings.
     */
    @Column(name = "refresh_token")
    private String refreshToken;

    /**
     * Set of scopes granted by the provider (e.g., "tasks.read", "users.write").
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "available_scope",
            joinColumns = @JoinColumn(name = "oauth2_external_connection_id")
    )
    @Column(name = "scope")
    private Set<String> scopes;

    /**
     * The token type returned by the OAuth2 provider (e.g., "Bearer").
     */
    @Column(name = "token_type")
    private String tokenType;
}
