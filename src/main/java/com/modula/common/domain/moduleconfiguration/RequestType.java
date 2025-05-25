package com.modula.common.domain.moduleconfiguration;

public enum RequestType {

    // === GET ===

    /**
     * GET request with access token parameters passed via URL query string.
     * Example: ?client_id=...&code=...
     */
    GET_WITH_URL_PARAMS,

    // === POST (most common for OAuth2) ===

    /**
     * POST request with parameters sent as x-www-form-urlencoded (RFC-compliant).
     * Content-Type: application/x-www-form-urlencoded
     * Body: client_id=...&client_secret=...&code=...
     */
    POST_WITH_FORM_URLENCODED,

    /**
     * POST request with parameters sent as JSON.
     * Content-Type: application/json
     * Body: { "client_id": "...", "client_secret": "...", "code": "..." }
     */
    POST_WITH_JSON_BODY,

    /**
     * POST request with parameters in URL (rare), body is empty.
     * URL: /token?client_id=...&code=...
     * Body: empty
     */
    POST_WITH_URL_PARAMS,

    /**
     * POST request with body formatted as multipart/form-data.
     * Used in rare cases like file upload or legacy APIs.
     */
    POST_WITH_MULTIPART_BODY,

    /**
     * POST request with both URL params and body (edge case).
     * URL: /token?code=...
     * Body: { "client_id": "...", "client_secret": "..." }
     */
    POST_WITH_JSON_AND_URL_PARAMS,

    /**
     * POST request with raw body (e.g., XML, plain text, or vendor-specific format).
     */
    POST_WITH_RAW_BODY,

    // === PUT (uncommon for OAuth but possible in some vendor APIs) ===

    /**
     * PUT request with JSON body (nonstandard in OAuth2, but possible in custom flows).
     */
    PUT_WITH_JSON_BODY,

    /**
     * PUT request with form-urlencoded body.
     */
    PUT_WITH_FORM_URLENCODED,

    // === Other / fallback ===

    /**
     * Request type requires custom/manual handling logic.
     */
    CUSTOM,

    /**
     * No request is made (e.g., offline token, or unsupported configuration).
     */
    NONE
}

