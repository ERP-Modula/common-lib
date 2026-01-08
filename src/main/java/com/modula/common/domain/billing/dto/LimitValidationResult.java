package com.modula.common.domain.billing.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Результат валидации лимитов операции
 */
@Data
@Builder
public class LimitValidationResult {

    /**
     * Разрешена ли операция
     */
    private boolean allowed;

    /**
     * Тип результата валидации
     */
    private ValidationType type;

    /**
     * Текущий баланс токенов
     */
    private Long currentBalance;

    /**
     * Требуемое количество токенов
     */
    private Long requiredTokens;

    /**
     * Сообщение для пользователя
     */
    private String message;

    /**
     * Является ли это предупреждением (операция разрешена, но есть warning)
     */
    private boolean warning;

    public enum ValidationType {
        SUCCESS,                  // Операция разрешена
        WARNING,                  // Разрешена с предупреждением (80-90% лимита)
        INSUFFICIENT_BALANCE,     // Недостаточно токенов
        NO_ACTIVE_SUBSCRIPTION,   // Нет активной подписки
        SUBSCRIPTION_PAST_DUE,    // Подписка просрочена
        OPERATION_NOT_ALLOWED     // Операция запрещена
    }

    // Фабричные методы для удобства

    public static LimitValidationResult success(Long currentBalance, Long requiredTokens) {
        return LimitValidationResult.builder()
                .allowed(true)
                .type(ValidationType.SUCCESS)
                .currentBalance(currentBalance)
                .requiredTokens(requiredTokens)
                .message("Operation allowed")
                .warning(false)
                .build();
    }

    public static LimitValidationResult successWithWarning(Long currentBalance,
                                                           Long requiredTokens,
                                                           String warningMessage) {
        return LimitValidationResult.builder()
                .allowed(true)
                .type(ValidationType.WARNING)
                .currentBalance(currentBalance)
                .requiredTokens(requiredTokens)
                .message(warningMessage)
                .warning(true)
                .build();
    }

    public static LimitValidationResult insufficientBalance(Long currentBalance,
                                                            Long requiredTokens,
                                                            String message) {
        return LimitValidationResult.builder()
                .allowed(false)
                .type(ValidationType.INSUFFICIENT_BALANCE)
                .currentBalance(currentBalance)
                .requiredTokens(requiredTokens)
                .message(message)
                .warning(false)
                .build();
    }

    public static LimitValidationResult noActiveSubscription(Long currentBalance, String message) {
        return LimitValidationResult.builder()
                .allowed(false)
                .type(ValidationType.NO_ACTIVE_SUBSCRIPTION)
                .currentBalance(currentBalance)
                .requiredTokens(0L)
                .message(message)
                .warning(false)
                .build();
    }

    public static LimitValidationResult subscriptionPastDue(Long currentBalance, String message) {
        return LimitValidationResult.builder()
                .allowed(false)
                .type(ValidationType.SUBSCRIPTION_PAST_DUE)
                .currentBalance(currentBalance)
                .requiredTokens(0L)
                .message(message)
                .warning(false)
                .build();
    }
}