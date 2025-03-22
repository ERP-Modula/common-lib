package com.modula.common.dto;

import com.modula.common.domain.step.Metadata;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
public class StepDTO {
    private String type;
    private String source;
    @ElementCollection
    private List<UUID> prevStepId;
    @ElementCollection
    private List<UUID> nextStepId;
    @Embedded
    private Metadata metadata;
    @ElementCollection
    private Map<String, String> parametersConfiguration;
}
