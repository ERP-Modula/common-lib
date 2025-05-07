package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enumeration of supported trigger types for modules.
 * A trigger determines how the system will receive event notifications
 * from an external service.
 */
@Getter
@RequiredArgsConstructor
public enum TriggerType {

    /**
     * Trigger based on incoming HTTP requests from an external system (webhook).
     */
    WEBHOOK,

    /**
     * Trigger based on periodic polling of an external API.
     * Typically used when webhook delivery is not supported.
     */
    POLLING
}
