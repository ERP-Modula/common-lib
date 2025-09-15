package com.modula.common.domain.billing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Подписка пользователя на тарифный план
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * ID плана подписки
     */
    @ManyToOne
    @JoinColumn(name = "subscription_plan_id")
    private SubscriptionPlan subscriptionPlan;

    /**
     * Статус подписки
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status = SubscriptionStatus.ACTIVE;

    /**
     * Дата начала подписки
     */
    @Column(nullable = false)
    private ZonedDateTime startDate;

    /**
     * Дата окончания подписки
     */
    private ZonedDateTime endDate;

    /**
     * Автопродление подписки
     */
    @Column(nullable = false)
    private boolean autoRenew = true;

    /**
     * Дата создания подписки
     */
    @Column(nullable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    /**
     * Дата последнего обновления
     */
    private ZonedDateTime updatedAt;

    /**
     * Дата следующего списания (для автопродления)
     */
    private ZonedDateTime nextBillingDate;

    /**
     * Создание новой подписки
     */
    public Subscription(SubscriptionPlan subscriptionPlan, ZonedDateTime startDate,
            ZonedDateTime endDate, boolean autoRenew) {
        this.subscriptionPlan = subscriptionPlan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.autoRenew = autoRenew;
        this.createdAt = ZonedDateTime.now();
    }

    /**
     * Проверяет, активна ли подписка
     */
    public boolean isActive() {
        return status == SubscriptionStatus.ACTIVE &&
                (endDate == null || endDate.isAfter(ZonedDateTime.now()));
    }

    /**
     * Проверяет, истекла ли подписка
     */
    public boolean isExpired() {
        return endDate != null && endDate.isBefore(ZonedDateTime.now());
    }

    /**
     * Активирует подписку
     */
    public void activate() {
        this.status = SubscriptionStatus.ACTIVE;
        this.updatedAt = ZonedDateTime.now();
    }

    /**
     * Приостанавливает подписку
     */
    public void suspend() {
        this.status = SubscriptionStatus.SUSPENDED;
        this.updatedAt = ZonedDateTime.now();
    }

    /**
     * Отменяет подписку
     */
    public void cancel() {
        this.status = SubscriptionStatus.CANCELLED;
        this.autoRenew = false;
        this.updatedAt = ZonedDateTime.now();
    }

    /**
     * Помечает подписку как истекшую
     */
    public void expire() {
        this.status = SubscriptionStatus.EXPIRED;
        this.autoRenew = false;
        this.updatedAt = ZonedDateTime.now();
    }

    /**
     * Продлевает подписку
     */
    public void renew(ZonedDateTime newEndDate) {
        this.endDate = newEndDate;
        this.status = SubscriptionStatus.ACTIVE;
        this.updatedAt = ZonedDateTime.now();
    }

    /**
     * Обновляет дату следующего списания
     */
    public void updateNextBillingDate(ZonedDateTime nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
        this.updatedAt = ZonedDateTime.now();
    }
}
