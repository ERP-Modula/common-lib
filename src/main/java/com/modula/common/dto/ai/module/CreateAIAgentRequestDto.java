package com.modula.common.dto.ai.module;

import lombok.Data;
import java.util.UUID;
import java.util.Set;

@Data
public class CreateAIAgentRequestDto {
    private String name;
    private String description;
    private String systemPrompt;
    private String llmProvider;
    private String llmModelName;
    private UUID connectionId;
    private UUID conversationMemoryId;
    private Set<UUID> knowledgeBaseIds;
    private Set<UUID> instrumentIds;
    private boolean useInternetSearch;
    private UUID workspaceId;
}