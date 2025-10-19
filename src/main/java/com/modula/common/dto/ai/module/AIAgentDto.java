package com.modula.common.dto.ai.module;

import lombok.Data;
import java.util.UUID;
import java.util.Set;

@Data
public class AIAgentDto {
    private UUID id;
    private String name;
    private String description;
    private String systemPrompt;
    private String llmProvider;
    private String llmModelName;
    private UUID connectionId;
    private ConversationMemoryDto conversationMemory;
    private Set<KnowledgeBaseDto> knowledgeBases;
    private Set<InstrumentDto> instruments;
    private boolean useInternetSearch;
    private UUID workspaceId;
}