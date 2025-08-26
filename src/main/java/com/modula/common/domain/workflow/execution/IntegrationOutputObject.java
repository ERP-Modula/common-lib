package com.modula.common.domain.workflow.execution;

import com.fasterxml.jackson.databind.JsonNode;
import com.modula.common.domain.workflow.step.Step;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
public class IntegrationOutputObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Timestamp startTime;
    private Timestamp endTime;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "step_id")
    private Step step;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workflow_instance_id")
    private WorkflowInstance workflowInstance;
    @Enumerated(EnumType.STRING)
    private IntegrationOutputStatus status = IntegrationOutputStatus.UNPROCESSED;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private JsonNode outputJsonPayload;
}