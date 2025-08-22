package com.modula.common.domain.workflow.execution.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionWasCreated {
    private UUID connectionId;
    private String moduleName;
    private Map<String, String> connectionParams;
}