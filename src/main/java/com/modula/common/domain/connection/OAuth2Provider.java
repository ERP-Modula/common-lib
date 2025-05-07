package com.modula.common.domain.connection;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * Represents an OAuth2-specific provider, extending the base {@link Provider} entity.
 * This class includes all OAuth2-related fields such as client credentials,
 * token URI, and optional extra query parameters used during token exchange.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oauth2_provider")
public class OAuth2Provider extends Provider {

    /**
     * OAuth2 client ID, issued by the external provider (e.g., Google).
     * Example: "123456-abcd.apps.googleusercontent.com"
     */
    @Column(name = "client_id", nullable = false)
    private String clientId;

    /**
     * OAuth2 client secret associated with the client ID.
     * This is sensitive information and must be handled securely.
     */
    @Column(name = "client_secret", nullable = false)
    private String clientSecret;


    /**
     * The endpoint URL for requesting access tokens.
     * Example: "https://oauth2.googleapis.com/token"
     */
    @Column(name = "token_uri", nullable = false)
    private String tokenUri;

    /**
     * Additional query parameters to include in the token request.
     * Example: {"access_type": "offline"}
     */
    @ElementCollection
    @CollectionTable(name = "extra_query_params")
    private Map<String, String> extraQueryParams;
}
