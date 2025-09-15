package com.modula.common.domain.billing.events;

import com.modula.common.domain.billing.SubscriptionStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Событие обновления подписки
 */
@Getter
@RequiredArgsConstructor
public class SubscriptionUpdatedEvent {

    /**
     * ID пользователя
     */
    private final String userId;

    /**
     * ID подписки
     */
    private final UUID subscriptionId;

    /**
     * ID плана подписки
     */
    private final UUID planId;

    /**
     * Старый статус подписки
     */
    private final SubscriptionStatus oldStatus;

    /**
     * Новый статус подписки
     */
    private final SubscriptionStatus newStatus;

    /**
     * Время события
     */
    private final ZonedDateTime timestamp = ZonedDateTime.now();
}
