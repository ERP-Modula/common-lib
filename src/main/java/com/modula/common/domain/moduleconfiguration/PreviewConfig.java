package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * Configuration for preview rendering of output fields.
 * Defines how a field should be displayed in preview mode.
 */
@Entity
@Data
public class PreviewConfig {

    /**
     * Unique identifier of the preview configuration.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Type of preview rendering to use.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PreviewType previewType;

    /**
     * JSONPath expression to extract the value for preview from the output data.
     * Example: "$.data.image_url" or "$.result.audio_file"
     */
    @Column(nullable = false)
    private String jsonPath;

    /**
     * Additional configuration for preview rendering.
     * This can contain type-specific settings like:
     * - For IMAGE: width, height, alt text
     * - For AUDIO: controls, autoplay
     * - For VIDEO: width, height, controls
     * - For DATETIME: format pattern
     * - For CURRENCY: currency code, locale
     * - For CHART: chart type, colors
     * - For MAP: zoom level, center coordinates
     */
    @Column(columnDefinition = "TEXT")
    private String configJson;

    /**
     * Human-readable label for the preview field.
     * If not provided, will use the field's label.
     */
    private String label;

    /**
     * Description of what this preview shows.
     * Can be used as tooltip or help text.
     */
    private String description;

    /**
     * Whether this preview field should be shown by default.
     * If false, user needs to explicitly enable it.
     */
    @Column(nullable = false)
    private boolean enabledByDefault = true;

    /**
     * Priority for ordering preview fields.
     * Lower numbers appear first.
     */
    @Column(nullable = false)
    private int displayOrder = 0;
}
