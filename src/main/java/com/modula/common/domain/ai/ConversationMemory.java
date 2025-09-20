package com.modula.common.domain.ai;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ai_conversation_memory")
@Getter
@Setter
public class ConversationMemory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemoryType provider;

    @Column(nullable = false)
    private UUID workspaceId;
}