package com.modula.common.domain.workflow.step;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StepType {
    ACTION("action"), // URL
    TRIGGER("trigger"); // Подключение к модулю

    private final String value;

    @Override
    public String toString() {
        return this.value;
    }
}
