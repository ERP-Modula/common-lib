package com.modula.common.domain.ai;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "ai_available_models")
@Getter
@Setter
public class AIAvailableModel {

    @Id
    private UUID id;

    @Column(nullable = false)
    private String provider;

    @Column(name = "model_name", nullable = false, unique = true)
    private String modelName;

    @Column(name = "model_type", nullable = false)
    private String modelType; // "LLM" или "EMBEDDING"

    @Column(name = "is_active", nullable = false)
    private boolean isActive;
}