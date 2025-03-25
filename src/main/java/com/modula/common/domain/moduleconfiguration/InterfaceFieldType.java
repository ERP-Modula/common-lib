package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InterfaceFieldType {
    ANY("any"),
    ARRAY("array"),
    BOOLEAN("boolean"),
    BUFFER("buffer"),
    STRING("string"),
    DATE("date"),
    NUMBER("number"),
    TEXT("text");

    private final String name;
}
