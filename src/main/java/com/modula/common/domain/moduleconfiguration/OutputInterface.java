package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * Describes a single output field returned by a module's action or trigger.
 * Can also be a nested structure when representing a complex object.
 */
@Entity
@Data
public class OutputInterface {

    /**
     * Unique identifier of the output field.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * System name of the field (e.g., "deal_id").
     * Used for programmatic access.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Data type of the field (e.g., STRING, NUMBER, BOOLEAN).
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "param_type", nullable = false)
    private InterfaceFieldType paramTypeEnum;

    /**
     * Human-readable label (e.g., "Deal ID").
     */
    @Column(nullable = false)
    private String label;

    /**
     * Indicates if this field is a timestamp.
     * Helps renderers and serializers format it accordingly.
     */
    @Column(nullable = false)
    private boolean time;

    /**
     * Nested structure for complex object types.
     * For example, if this field is a contact object, it may contain name, phone, etc.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputInterface> spec;
}