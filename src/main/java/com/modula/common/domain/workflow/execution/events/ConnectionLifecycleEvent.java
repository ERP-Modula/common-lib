package com.modula.common.domain.workflow.execution.events;

import com.modula.common.connections.dto.connection.ExternalConnectionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionLifecycleEvent {

    private ConnectionEventType eventType;
    private ExternalConnectionDto connection;
}