package com.modula.common.domain.billing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * Баланс токенов пользователя
 */
@Entity
@Getter
@Setter
public class TokenBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Текущий баланс токенов
     */
    @Column(nullable = false)
    private Long currentBalance = 0L;

    /**
     * Всего заработано токенов за все время
     */
    @Column(nullable = false)
    private Long totalEarned = 0L;

    /**
     * Всего потрачено токенов за все время
     */
    @Column(nullable = false)
    private Long totalSpent = 0L;

    /**
     * Дата последнего обновления баланса
     */
    @Column(nullable = false)
    private ZonedDateTime lastUpdated = ZonedDateTime.now();

    /**
     * Дата создания баланса
     */
    @Column(nullable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    /**
     * Создание нового баланса для пользователя
     */
    public TokenBalance() {
        this.currentBalance = 0L;
        this.totalEarned = 0L;
        this.totalSpent = 0L;
        this.createdAt = ZonedDateTime.now();
        this.lastUpdated = ZonedDateTime.now();
    }

    /**
     * Проверяет, достаточно ли токенов для операции
     */
    public boolean hasEnoughTokens(Long requiredTokens) {
        return currentBalance >= requiredTokens;
    }

    /**
     * Списание токенов
     */
    public void deductTokens(Long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currentBalance < amount) {
            throw new IllegalStateException("Insufficient token balance");
        }

        this.currentBalance -= amount;
        this.totalSpent += amount;
        this.lastUpdated = ZonedDateTime.now();
    }

    /**
     * Пополнение токенов
     */
    public void addTokens(Long amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        this.currentBalance += amount;
        this.totalEarned += amount;
        this.lastUpdated = ZonedDateTime.now();
    }

    /**
     * Сброс баланса (для тестирования)
     */
    public void resetBalance() {
        this.currentBalance = 0L;
        this.totalEarned = 0L;
        this.totalSpent = 0L;
        this.lastUpdated = ZonedDateTime.now();
    }

    /**
     * Проверяет, является ли баланс пустым
     */
    public boolean isEmpty() {
        return currentBalance == 0L;
    }
}
