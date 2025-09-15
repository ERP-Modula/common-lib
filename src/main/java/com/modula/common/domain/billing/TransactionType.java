package com.modula.common.domain.billing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Типы транзакций токенов
 */
@Getter
@RequiredArgsConstructor
public enum TransactionType {
    DEBIT("Списание"),
    CREDIT("Пополнение");

    private final String description;
}
