package com.modula.common.domain.ai;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "ai_knowledge_base")
@Getter
@Setter
public class KnowledgeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String embeddingModelProvider;

    @Column(nullable = false)
    private String embeddingModelName;

    //TODO: Create files db table

    @Column(nullable = false)
    private UUID workspaceId;
}