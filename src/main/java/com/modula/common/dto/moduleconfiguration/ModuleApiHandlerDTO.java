package com.modula.common.dto.moduleconfiguration;

import com.modula.common.domain.moduleconfiguration.ResponseType;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ModuleApiHandlerDTO {
    private UUID id;
    private String name;
    private String label;
    private String description;
    private String category;
    private String handlerType;
    private ResponseType responseType;
    private List<PreviewConfigDTO> previewConfigs;
}
