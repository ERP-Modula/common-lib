package com.modula.common.domain.billing.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Событие списания токенов за выполнение операции
 */
@Getter
@RequiredArgsConstructor
public class TokenDeductionEvent {

    /**
     * ID пользователя
     */
    private final String userId;

    /**
     * ID транзакции
     */
    private final UUID transactionId;

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
     * Количество списанных токенов
     */
    private final Long tokenAmount;

    /**
     * Описание операции
     */
    private final String description;

    /**
     * Время события
     */
    private final ZonedDateTime timestamp = ZonedDateTime.now();
}
