package com.modula.common.dto.module;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ModuleShortInfoDTO {
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String iconPath;
    private String logoKey;
    private Boolean isPublic;
    private String theme;
    private String authorId;
    private List<String> categories;
    private List<String> keywords;
    private String latestVersion;
    private String defaultVersion;
    private List<ModuleActionShortInfoDTO> actions;
    private List<ModuleTriggerShortInfoDTO> triggers;
}
