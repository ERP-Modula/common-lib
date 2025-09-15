package com.modula.common.domain.billing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Статусы транзакций
 */
@Getter
@RequiredArgsConstructor
public enum TransactionStatus {
    PENDING("В обработке"),
    COMPLETED("Завершена"),
    FAILED("Неудачная"),
    CANCELLED("Отменена");

    private final String description;
}
