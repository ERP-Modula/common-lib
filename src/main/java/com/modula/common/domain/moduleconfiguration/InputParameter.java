package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class InputParameter {

    /**
     * Unique identifier of the input parameter.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * System name of the parameter (e.g., "user_id").
     * Used for internal mapping and referencing in payloads.
     */
    private String name;

    /**
     * Human-readable label (e.g., "User ID").
     * Shown in the UI as the field label.
     */
    private String label;

    /**
     * Indicates whether the parameter is required to proceed.
     */
    private Boolean required;

    /**
     * Help text or tooltip to guide the user.
     */
    private String help;

    /**
     * Type of the parameter (e.g., STRING, NUMBER, SELECT).
     */
    @Enumerated(EnumType.STRING)
    private ParamType type;

    /**
     * Optional list of selectable options.
     * Used when the parameter type is SELECT or similar.
     * Each option may contain nested input parameters.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NestedFieldOption> options;

    /**
     * Nested parameters for complex types (e.g., OBJECT or COLLECTION).
     * This enables recursive specification of structured input.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputParameter> spec;
}