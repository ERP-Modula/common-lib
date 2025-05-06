package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

/**
 * Represents a selectable option for an input parameter that has nested fields.
 * Commonly used for input types like dropdowns or radio buttons,
 * where selecting a value reveals additional input fields.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class NestedFieldOption {

    /**
     * Unique identifier for the nested field option.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Human-readable label for the option (e.g., "By Email").
     */
    @Column(nullable = false)
    private String label;

    /**
     * Internal value of the option (e.g., "email").
     * This is what gets submitted when the option is selected.
     */
    @Column(nullable = false)
    private String value;

    /**
     * The expected type of the value (e.g., STRING, BOOLEAN).
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ParamType type;

    /**
     * Indicates if this option is selected by default.
     */
    @Column(nullable = false)
    private Boolean isDefault = false;

    /**
     * Nested input parameters that should appear when this option is selected.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputParameter> nested;
}
