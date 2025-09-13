package com.modula.common.domain.workflow.execution.events;

import com.modula.common.connections.dto.connection.ExternalConnectionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionLifecycleEvent {
    private UUID workspaceId;
    private ConnectionEventType eventType;
    private String moduleName;
    private ExternalConnectionDto connection;
}