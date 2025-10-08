package com.modula.common.domain.ai;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "ai_instrument")
@Getter
@Setter
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descriptionForLlm;

    @Column(nullable = false)
    private UUID workflowId;

    @Column(nullable = false)
    private UUID workspaceId;
}