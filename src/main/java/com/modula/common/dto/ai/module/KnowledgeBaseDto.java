package com.modula.common.dto.ai.module;

import lombok.Data;
import java.util.UUID;

@Data
public class KnowledgeBaseDto {
    private UUID id;
    private String name;
    private String embeddingModelProvider;
    private String embeddingModelName;
    private UUID workspaceId;
}