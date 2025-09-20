package com.modula.common.domain.ai;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "ai_agent")
@Getter
@Setter
public class AIAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String systemPrompt;

    @Column(nullable = false)
    private String llmProvider;

    @Column(nullable = false)
    private String llmModelName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_memory_id")
    private ConversationMemory conversationMemory;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ai_agent_knowledge_bases",
            joinColumns = @JoinColumn(name = "ai_agent_id"),
            inverseJoinColumns = @JoinColumn(name = "knowledge_base_id")
    )
    private Set<KnowledgeBase> knowledgeBases;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ai_agent_instruments",
            joinColumns = @JoinColumn(name = "ai_agent_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id")
    )
    private Set<Instrument> instruments;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean useInternetSearch;

    @Column(nullable = false)
    private UUID workspaceId;
}