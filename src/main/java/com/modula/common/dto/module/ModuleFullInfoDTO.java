package com.modula.common.dto.module;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ModuleFullInfoDTO {
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<ModuleVersionInfoDTO> versions;
}
