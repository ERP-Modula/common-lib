package com.modula.common.domain.workflow.step;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StepType {
    ACTION("action"), // URL
    TRIGGER_WEBHOOK("trigger"), // Подключение к модулю
    TRIGGER_POLLING("trigger_polling");

    private final String value;

    @Override
    public String toString() {
        return this.value;
    }
}
