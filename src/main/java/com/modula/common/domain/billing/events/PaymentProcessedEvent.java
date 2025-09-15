package com.modula.common.domain.billing.events;

import com.modula.common.domain.billing.PaymentStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Событие обработки платежа
 */
@Getter
@RequiredArgsConstructor
public class PaymentProcessedEvent {

    /**
     * ID пользователя
     */
    private final String userId;

    /**
     * ID платежа
     */
    private final UUID paymentId;

    /**
     * ID подписки
     */
    private final UUID subscriptionId;

    /**
     * Сумма платежа
     */
    private final BigDecimal amount;

    /**
     * Валюта
     */
    private final String currency;

    /**
     * Статус платежа
     */
    private final PaymentStatus status;

    /**
     * Внешний ID платежа
     */
    private final String externalPaymentId;

    /**
     * Время события
     */
    private final ZonedDateTime timestamp = ZonedDateTime.now();
}
