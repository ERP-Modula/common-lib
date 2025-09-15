package com.modula.common.domain.billing.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Событие недостатка токенов для выполнения операции
 */
@Getter
@RequiredArgsConstructor
public class InsufficientTokensEvent {

    /**
     * ID пользователя
     */
    private final String userId;

    /**
     * ID типа операции
     */
    private final UUID operationTypeId;

    /**
     * ID шага workflow
     */
    private final UUID stepId;

    /**
     * ID экземпляра workflow
     */
    private final UUID workflowInstanceId;

    /**
     * Требуемое количество токенов
     */
    private final Long requiredTokens;

    /**
     * Текущий баланс токенов
     */
    private final Long currentBalance;

    /**
     * Описание операции
     */
    private final String description;

    /**
     * Время события
     */
    private final ZonedDateTime timestamp = ZonedDateTime.now();
}
