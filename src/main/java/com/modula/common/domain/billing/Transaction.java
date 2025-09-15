package com.modula.common.domain.billing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Транзакция списания/пополнения токенов
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * ID пользователя
     */
    @Column(nullable = false)
    private String userId;

    /**
     * ID типа операции
     */
    @Column(nullable = false)
    private UUID operationTypeId;

    /**
     * ID шага workflow (может быть null для пополнений)
     */
    private UUID stepId;

    /**
     * ID экземпляра workflow (может быть null для пополнений)
     */
    private UUID workflowInstanceId;

    /**
     * Количество токенов
     */
    @Column(nullable = false)
    private Long tokenAmount;

    /**
     * Тип транзакции
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    /**
     * Описание транзакции
     */
    private String description;

    /**
     * Статус транзакции
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status = TransactionStatus.PENDING;

    /**
     * Дата создания транзакции
     */
    @Column(nullable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    /**
     * Дата завершения транзакции
     */
    private ZonedDateTime completedAt;

    /**
     * Причина отмены (если транзакция отменена)
     */
    private String cancellationReason;

    /**
     * Создание новой транзакции
     */
    public Transaction(String userId, UUID operationTypeId, UUID stepId,
            UUID workflowInstanceId, Long tokenAmount,
            TransactionType transactionType, String description) {
        this.userId = userId;
        this.operationTypeId = operationTypeId;
        this.stepId = stepId;
        this.workflowInstanceId = workflowInstanceId;
        this.tokenAmount = tokenAmount;
        this.transactionType = transactionType;
        this.description = description;
        this.createdAt = ZonedDateTime.now();
    }

    /**
     * Завершает транзакцию успешно
     */
    public void complete() {
        this.status = TransactionStatus.COMPLETED;
        this.completedAt = ZonedDateTime.now();
    }

    /**
     * Отменяет транзакцию
     */
    public void cancel(String reason) {
        this.status = TransactionStatus.CANCELLED;
        this.cancellationReason = reason;
        this.completedAt = ZonedDateTime.now();
    }

    /**
     * Помечает транзакцию как неудачную
     */
    public void fail(String reason) {
        this.status = TransactionStatus.FAILED;
        this.cancellationReason = reason;
        this.completedAt = ZonedDateTime.now();
    }

    /**
     * Проверяет, является ли транзакция списанием
     */
    public boolean isDebit() {
        return transactionType == TransactionType.DEBIT;
    }

    /**
     * Проверяет, является ли транзакция пополнением
     */
    public boolean isCredit() {
        return transactionType == TransactionType.CREDIT;
    }

    /**
     * Проверяет, завершена ли транзакция
     */
    public boolean isCompleted() {
        return status == TransactionStatus.COMPLETED;
    }
}
