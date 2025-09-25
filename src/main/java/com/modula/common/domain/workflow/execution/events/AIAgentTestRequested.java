package com.modula.common.domain.workflow.execution.events;

import com.modula.common.dto.ai.module.AIAgentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AIAgentTestRequested {
    private String sessionId;
    private UUID threadId;
    private String prompt;
    private AIAgentDto agentConfig;
    private Map<String, Object> llmParams;
}