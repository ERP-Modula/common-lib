package com.modula.common.domain.billing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Категории операций для группировки и тарификации
 */
@Getter
@RequiredArgsConstructor
public enum OperationCategory {
    API_CALL("API вызов"),
    AI_OPERATION("AI операция"),
    WEBHOOK_TRIGGER("Webhook триггер"),
    POLLING_TRIGGER("Polling триггер"),
    CONDITION_STEP("Условие"),
    DATA_TRANSFORMATION("Трансформация данных"),
    NOTIFICATION("Уведомление"),
    FILE_OPERATION("Работа с файлами"),
    DATABASE_OPERATION("Операция с БД"),
    CUSTOM_OPERATION("Пользовательская операция");

    private final String description;

    /**
     * Возвращает базовую стоимость для категории (для новых операций)
     */
    public Long getBaseTokenCost() {
        return switch (this) {
            case AI_OPERATION -> 10L; // AI операции самые дорогие
            case FILE_OPERATION -> 5L;
            case DATABASE_OPERATION -> 3L;
            case DATA_TRANSFORMATION -> 2L;
            case API_CALL -> 1L;
            case WEBHOOK_TRIGGER, POLLING_TRIGGER -> 1L;
            case CONDITION_STEP -> 0L; // Условия бесплатные
            case NOTIFICATION -> 1L;
            case CUSTOM_OPERATION -> 2L;
        };
    }
}
