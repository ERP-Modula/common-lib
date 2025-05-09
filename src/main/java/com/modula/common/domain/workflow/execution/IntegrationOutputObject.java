package com.modula.common.domain.workflow.execution;

import com.fasterxml.jackson.databind.JsonNode;
import com.modula.common.domain.connection.Provider;
import com.modula.common.domain.workflow.step.Step;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
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

//    TODO change column def to jsonb
    @Column(columnDefinition = "text")
    private String outputJsonPayload; // JsonNode.toString()
}
