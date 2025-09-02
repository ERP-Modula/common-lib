package com.modula.common.domain.workflow.step;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Value Object, представляющий поле source из Step.
 * Инкапсулирует логику парсинга строки формата moduleName:resourceName.
 * Предоставляет типизированный доступ к ее частям.
 */
@Getter
public final class StepSource implements Serializable {

    private final String moduleName;
    private final String resourceName;

    /**
     * Конструктор, который парсит и валидирует исходную строку.
     * @param rawSource Строка из поля Step.source, например, "bitrix:create_deal".
     * @throws IllegalArgumentException если строка имеет неверный формат.
     */
    public StepSource(String rawSource) {
        Objects.requireNonNull(rawSource, "Raw source string cannot be null.");
        String[] parts = rawSource.split(":", 2);

        if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid source format. Expected 'moduleName:resourceName', but got: " + rawSource);
        }
        this.moduleName = parts[0].trim();
        this.resourceName = parts[1].trim();
    }

    @Override
    public String toString() {
        return moduleName + ":" + resourceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StepSource that = (StepSource) o;
        return moduleName.equals(that.moduleName) && resourceName.equals(that.resourceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleName, resourceName);
    }
}