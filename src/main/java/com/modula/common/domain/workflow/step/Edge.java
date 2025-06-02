package com.modula.common.domain.workflow.step;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edge {
    private String id;          // Уникальный идентификатор соединения
    private String source;      // ID исходной ноды
    private String target;      // ID целевой ноды
    private String type;        // Тип соединения (например, "default", "smoothstep")
}
