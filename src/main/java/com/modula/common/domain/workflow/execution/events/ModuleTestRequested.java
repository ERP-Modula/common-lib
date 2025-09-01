package com.modula.common.domain.workflow.execution.events;

import com.modula.common.connections.dto.connection.ExternalConnectionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
import java.util.UUID;

/**
 * Универсальное событие, инициирующее тестовый запуск любого шага в integration-modules.
 * Отправляется из core-processor. Заменяет собой старый TriggerTestRequestPublished.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleTestRequested {
    private UUID stepId;
    private UUID sessionId; // Для обратной связи через WebSocket
    private String stepType;
    private Map<String, Object> params;
    private ExternalConnectionDto connection;
}