package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents the data type of input or output parameter.
 * Used to render input fields in the UI and validate incoming data.
 */
@Getter
@RequiredArgsConstructor
public enum ParamType {

    /** Any data type is allowed (no restriction). */
    ANY("any"),

    /** An array of values. */
    ARRAY("array"),

    /** Boolean value (true/false). */
    BOOLEAN("boolean"),

    /** Binary buffer, such as a file or byte stream. */
    BUFFER("buffer"),

    /** Simple string value. */
    STRING("string"),

    /** A collection, similar to an array but often tied to external sources. */
    COLLECTION("collection"),
    CUSTOM_WEBHOOK("webhook"),
    CONDITION("condition"),

    /** JSON object with nested structure. */
    OBJECT("object"),

    /** Date value. */
    DATE("date"),

    /** Email address. */
    EMAIL("email"),

    /** File name (not the file itself). */
    FILENAME("filename"),

    /** Numeric value (integer or floating point). */
    NUMBER("number"),

    /** A selectable value from a list. */
    SELECT("select"),

    /** Long text or multiline input. */
    TEXT("text"),

    /** URL address. */
    URL("url"),

    /** Connection reference to another module or service. */
    CONNECTION("connection");

    /**
     * String representation of the parameter type, used in JSON serialization or UI rendering.
     */
    private final String value;

    @Override
    public String toString() {
        return this.value;
    }
}
