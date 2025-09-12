package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents the preview type for output fields in module actions and triggers.
 * Used to determine how to render the field value in a human-readable format.
 */
@Getter
@RequiredArgsConstructor
public enum PreviewType {

    /** Default JSON view - no special preview */
    JSON("json"),

    /** Text content that should be displayed as formatted text */
    TEXT("text"),

    /** Image URL or base64 data that should be rendered as an image */
    IMAGE("image"),

    /** Audio URL or base64 data that should be rendered as an audio player */
    AUDIO("audio"),

    /** Video URL or base64 data that should be rendered as a video player */
    VIDEO("video"),

    /** File download link or file content */
    FILE("file"),

    /** URL that should be rendered as a clickable link */
    URL("url"),

    /** Email address that should be rendered as a mailto link */
    EMAIL("email"),

    /** Phone number that should be rendered as a tel link */
    PHONE("phone"),

    /** Date/time that should be formatted according to locale */
    DATETIME("datetime"),

    /** Currency amount that should be formatted with currency symbol */
    CURRENCY("currency"),

    /** HTML content that should be rendered as HTML */
    HTML("html"),

    /** Markdown content that should be rendered as formatted text */
    MARKDOWN("markdown"),

    /** Table data that should be rendered as a table */
    TABLE("table"),

    /** Chart data that should be rendered as a chart */
    CHART("chart"),

    /** Map coordinates that should be rendered as a map */
    MAP("map"),

    /** QR code data that should be rendered as a QR code */
    QR_CODE("qr_code"),

    /** Bar code data that should be rendered as a bar code */
    BAR_CODE("bar_code");

    /**
     * String representation of the preview type, used in serialization and UI rendering.
     */
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
