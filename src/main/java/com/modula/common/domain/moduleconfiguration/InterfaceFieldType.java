package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents the data type of field in the output interface.
 * Used to describe the structure and formatting of response fields
 * in actions and triggers.
 */
@Getter
@RequiredArgsConstructor
public enum InterfaceFieldType {

    /** No specific type defined; accepts any value. */
    ANY("any"),

    /** An array of values. */
    ARRAY("array"),

    /** Boolean value (true or false). */
    BOOLEAN("boolean"),

    /** Binary buffer or file content. */
    BUFFER("buffer"),

    /** A string value. */
    STRING("string"),

    /** A date or datetime value. */
    DATE("date"),

    /** Numeric value (integer or floating-point). */
    NUMBER("number"),

    /** Long or multiline text. */
    TEXT("text");

    /**
     * String representation of the field type, used in serialization and UI rendering.
     */
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
