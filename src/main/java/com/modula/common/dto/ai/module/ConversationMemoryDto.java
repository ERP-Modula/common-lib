package com.modula.common.dto.ai.module;

import lombok.Data;
import java.util.UUID;

@Data
public class ConversationMemoryDto {
    private UUID id;
    private String name;
    private String provider;
    private UUID workspaceId;
}