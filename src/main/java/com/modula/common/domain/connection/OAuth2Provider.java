package com.modula.common.domain.connection;

import com.modula.common.domain.moduleconfiguration.AuthType;
import com.modula.common.domain.moduleconfiguration.RequestType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;
import java.util.Set;

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
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "extra_query_params", joinColumns = @JoinColumn(name = "oauth2_provider_id"))
    @MapKeyColumn(name = "param_key")
    @Column(name = "param_value")
    private Map<String, String> extraQueryParams;

    /**
     * Specifies the HTTP request type to be used when obtaining the OAuth2 access token.
     * <p>
     * This field determines how the token request should be structured — including the HTTP method,
     * the format of the body (e.g., form-urlencoded, JSON), and whether parameters are passed
     * via the URL or request body.
     * <p>
     * Typical values include:
     * <ul>
     *     <li>{@code POST_WITH_FORM_URLENCODED} — standard OAuth2 flow (RFC 6749)</li>
     *     <li>{@code POST_WITH_JSON_BODY} — for APIs requiring JSON-formatted requests (e.g., Yandex Tracker)</li>
     *     <li>{@code GET_WITH_URL_PARAMS} — for legacy or simple integrations</li>
     *     <li>{@code CUSTOM} — for provider-specific request handling</li>
     * </ul>
     * This value must be explicitly set for each {@link OAuth2Provider} configuration.
     */
    @Column(name = "request_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RequestType requestType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "provider_default_scopes",
            joinColumns = @JoinColumn(name = "provider_id")
    )
    @Column(name = "scope")
    private Set<String> defaultScopes;
}
