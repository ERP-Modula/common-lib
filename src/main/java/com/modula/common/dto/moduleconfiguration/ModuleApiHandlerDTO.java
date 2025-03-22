package com.modula.common.dto.moduleconfiguration;

import lombok.Data;

import java.util.UUID;

@Data
public class ModuleApiHandlerDTO {
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String category;
}
