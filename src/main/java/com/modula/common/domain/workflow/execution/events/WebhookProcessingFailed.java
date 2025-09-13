package com.modula.common.domain.workflow.execution.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebhookProcessingFailed {
    private UUID workspaceId;
    private String moduleName;
    private UUID connectionId;
    private String reason;
    private String payloadSnippet;
}