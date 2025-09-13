package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Событие, информирующее о НЕУДАЧНОМ выполнении операции
 * жизненного цикла подключения.
 * Отправляется из integration-modules в core-processor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionLifecycleFailedEvent {
    private UUID workspaceId;
    private UUID connectionId;
    private String moduleName;
    private ConnectionEventType eventType;
    private String errorMessage;
    private JsonNode errorDetails;
}