package com.modula.common.dto.moduleconfiguration;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ModuleConfigurationShortInfoDTO {
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String iconPath;
    private String theme;
    private Boolean isPublic;
    private List<String> categories;
    private List<ModuleApiHandlerDTO> actions;
    private List<ModuleApiHandlerDTO> triggers;
}