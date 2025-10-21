package com.modula.common.dto.module;

import lombok.Data;

import java.util.UUID;

@Data
public class ModuleTriggerShortInfoDTO {
    private UUID id;
    private String type;
    private String name;
    private String label;
    private String description;
    private String handlerType;
    private String category;
}
