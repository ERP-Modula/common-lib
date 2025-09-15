package com.modula.common.domain.billing;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Статусы подписки пользователя
 */
@Getter
@RequiredArgsConstructor
public enum SubscriptionStatus {
    ACTIVE("Активна"),
    SUSPENDED("Приостановлена"),
    CANCELLED("Отменена"),
    EXPIRED("Истекла");

    private final String description;
}
