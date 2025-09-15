package com.modula.common.domain.billing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Статусы платежей
 */
@Getter
@RequiredArgsConstructor
public enum PaymentStatus {
    PENDING("В ожидании"),
    COMPLETED("Завершен"),
    FAILED("Неудачный"),
    CANCELLED("Отменен"),
    REFUNDED("Возвращен");

    private final String description;
}
