package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing the available authentication types
 * for external integration modules.
 */
@Getter
@RequiredArgsConstructor
public enum AuthType {

    /**
     * OAuth 2.0 authentication.
     * Commonly used for secure delegated access.
     */
    OAUTH2("oauth2"),

    /**
     * Basic authentication using username and password.
     * Suitable for simple or internal APIs.
     */
    BASIC("basic"),

    /**
     * API key authentication.
     * Useful for systems where token-based auth is sufficient.
     */
    API_KEY("api_key"),
    GOOGLE_OAUTH2("google_oauth2");

    /**
     * The string representation of the authentication type,
     * used for configuration and serialization.
     */
    private final String name;
}
