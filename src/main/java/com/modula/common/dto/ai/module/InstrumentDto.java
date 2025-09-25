package com.modula.common.dto.ai.module;

import lombok.Data;
import java.util.UUID;

@Data
public class InstrumentDto {
    private UUID id;
    private String name;
    private String descriptionForLlm;
    private UUID workflowId;
    private UUID workspaceId;
}