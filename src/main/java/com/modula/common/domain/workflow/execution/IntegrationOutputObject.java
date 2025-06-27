package com.modula.common.domain.workflow.execution;

import com.fasterxml.jackson.databind.JsonNode;
import com.modula.common.domain.workflow.step.Step;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Data
@Entity
public class IntegrationOutputObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "step_id")
    private Step step;
    //    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<OutputInterfaceField> fields;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private JsonNode outputJsonPayload;
}
