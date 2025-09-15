package com.modula.common.domain.billing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Платеж пользователя за подписку
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * ID пользователя
     */
    @Column(nullable = false)
    private String userId;

    /**
     * ID подписки
     */
    @Column(nullable = false)
    private UUID subscriptionId;

    /**
     * Сумма платежа
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    /**
     * Валюта платежа
     */
    @Column(nullable = false)
    private String currency = "RUB";

    /**
     * Статус платежа
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status = PaymentStatus.PENDING;

    /**
     * Провайдер платежей
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentProvider paymentProvider;

    /**
     * ID платежа во внешней системе
     */
    private String externalPaymentId;

    /**
     * URL для оплаты (если требуется)
     */
    private String paymentUrl;

    /**
     * Дата создания платежа
     */
    @Column(nullable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    /**
     * Дата завершения платежа
     */
    private ZonedDateTime completedAt;

    /**
     * Дата истечения платежа
     */
    private ZonedDateTime expiresAt;

    /**
     * Причина отмены (если платеж отменен)
     */
    private String cancellationReason;

    /**
     * Описание платежа
     */
    private String description;

    /**
     * Дополнительные данные платежа (JSON)
     */
    @Column(columnDefinition = "text")
    private String metadata;

    /**
     * Дата последнего обновления
     */
    private ZonedDateTime updatedAt;

    /**
     * Создание нового платежа
     */
    public Payment(String userId, UUID subscriptionId, BigDecimal amount,
            PaymentProvider paymentProvider) {
        this.userId = userId;
        this.subscriptionId = subscriptionId;
        this.amount = amount;
        this.paymentProvider = paymentProvider;
        this.createdAt = ZonedDateTime.now();
    }

    /**
     * Устанавливает внешний ID платежа
     */
    public void setExternalPaymentId(String externalPaymentId) {
        this.externalPaymentId = externalPaymentId;
        this.updatedAt = ZonedDateTime.now();
    }

    /**
     * Устанавливает URL для оплаты
     */
    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    /**
     * Устанавливает дату истечения
     */
    public void setExpiresAt(ZonedDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    /**
     * Завершает платеж успешно
     */
    public void complete() {
        this.status = PaymentStatus.COMPLETED;
        this.completedAt = ZonedDateTime.now();
    }

    /**
     * Отменяет платеж
     */
    public void cancel(String reason) {
        this.status = PaymentStatus.CANCELLED;
        this.cancellationReason = reason;
        this.completedAt = ZonedDateTime.now();
    }

    /**
     * Помечает платеж как неудачный
     */
    public void fail(String reason) {
        this.status = PaymentStatus.FAILED;
        this.cancellationReason = reason;
        this.completedAt = ZonedDateTime.now();
    }

    /**
     * Проверяет, истек ли платеж
     */
    public boolean isExpired() {
        return expiresAt != null && expiresAt.isBefore(ZonedDateTime.now());
    }

    /**
     * Проверяет, завершен ли платеж
     */
    public boolean isCompleted() {
        return status == PaymentStatus.COMPLETED;
    }

    /**
     * Проверяет, можно ли оплатить платеж
     */
    public boolean canBePaid() {
        return status == PaymentStatus.PENDING && !isExpired();
    }
}
