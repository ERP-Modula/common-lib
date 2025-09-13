package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing the expected response type for module actions and triggers.
 * Used to determine how to handle the response from external APIs.
 */
@Getter
@RequiredArgsConstructor
public enum ResponseType {
    /**
     * JSON response - default type for most APIs
     */
    JSON("json"),

    /**
     * Binary response - for files, images, audio, video, etc.
     */
    BINARY("binary"),

    /**
     * Plain text response
     */
    TEXT("text"),

    /**
     * HTML response
     */
    HTML("html"),

    /**
     * XML response
     */
    XML("xml");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
