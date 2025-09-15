package com.modula.common.domain.billing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Период биллинга для планов подписки
 */
@Getter
@RequiredArgsConstructor
public enum BillingPeriod {
    MONTHLY("Ежемесячно"),
    YEARLY("Ежегодно"),
    ONE_TIME("Единоразово");

    private final String description;

    /**
     * Возвращает количество дней в периоде
     */
    public int getDaysInPeriod() {
        return switch (this) {
            case MONTHLY -> 30;
            case YEARLY -> 365;
            case ONE_TIME -> 0; // Для единоразовых платежей
        };
    }
}
