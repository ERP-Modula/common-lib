package com.modula.common.domain.log;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Data
@Entity
@Table(name = "system_event_logs")
public class SystemEventLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Timestamp timestamp = Timestamp.from(Instant.now());

    @Column(nullable = false)
    private UUID workflowId;

    private UUID connectionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LogLevel level;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SystemEventType eventType;

    @Column(nullable = false)
    private String sourceService;

    @Column(nullable = false, length = 512)
    private String message;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private JsonNode details;
}