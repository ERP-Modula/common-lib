package com.modula.common.domain.workflow.execution.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Событие, информирующее об УСПЕШНОМ выполнении операции
 * жизненного цикла подключения.
 * Отправляется из integration-modules в core-processor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionLifecycleSucceededEvent {
    private UUID workspaceId;
    private UUID connectionId;
    private String moduleName;
    private ConnectionEventType eventType;
}