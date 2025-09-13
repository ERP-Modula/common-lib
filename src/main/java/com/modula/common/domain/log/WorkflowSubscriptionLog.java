package com.modula.common.domain.log;

import com.fasterxml.jackson.databind.JsonNode;
import com.modula.common.domain.workflow.execution.events.TriggerSubscriptionAction;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

/**
 * Хранит историю событий подписки/отписки для конкретного воркфлоу.
 */
@Data
@Entity
@Table(name = "workflow_subscription_logs")
public class WorkflowSubscriptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Timestamp timestamp = Timestamp.from(Instant.now());

    @Column(nullable = false)
    private UUID workflowId;

    @Column(nullable = false)
    private String moduleName;

    @Column(nullable = false)
    private String triggerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TriggerSubscriptionAction action;

    @Column(nullable = false)
    private String status;

    @Column(length = 512)
    private String message;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private JsonNode details;
}