package com.modula.common.dto.moduleconfiguration;

import com.modula.common.domain.moduleconfiguration.PreviewType;
import lombok.Data;

import java.util.UUID;

/**
 * DTO for PreviewConfig entity.
 * Used in API responses to represent preview configuration for actions and triggers.
 */
@Data
public class PreviewConfigDTO {
    private UUID id;
    private PreviewType previewType;
    private String jsonPath;
    private String configJson;
    private String label;
    private String description;
    private boolean enabledByDefault;
    private int displayOrder;
}
