package com.modula.common.domain.workflow.step;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Edge {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;          // Уникальный идентификатор соединения
    private UUID source;      // ID исходной ноды
    private UUID target;      // ID целевой ноды
    private String type;        // Тип соединения (например, "default", "smoothstep")
}
