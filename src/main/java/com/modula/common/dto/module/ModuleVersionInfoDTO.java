package com.modula.common.dto.module;

import com.modula.common.dto.moduleconfiguration.ModuleConfigurationShortInfoDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ModuleVersionInfoDTO {
    private UUID id;
    private String version;
    private String status;
    private String changelog;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isDefault;
    private ModuleConfigurationShortInfoDTO configuration;
}
