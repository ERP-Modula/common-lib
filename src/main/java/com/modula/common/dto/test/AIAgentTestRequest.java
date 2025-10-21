package com.modula.common.dto.test;

import lombok.Data;
import java.util.Map;
import java.util.UUID;

@Data
public class AIAgentTestRequest {
    private String sessionId;
    private UUID agentId;
    private String threadId;
    private String prompt;
    private Map<String, Object> llmParams;
}