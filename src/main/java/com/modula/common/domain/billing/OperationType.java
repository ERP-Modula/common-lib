package com.modula.common.domain.billing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Тип операции, определяющий стоимость выполнения различных действий
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class OperationType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Название типа операции
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Описание типа операции
     */
    private String description;

    /**
     * Стоимость в токенах
     */
    @Column(nullable = false)
    private Long tokenCost;

    /**
     * Активен ли тип операции
     */
    @Column(nullable = false)
    private boolean isActive = true;

    /**
     * Категория операции
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OperationCategory category;

    /**
     * Создание нового типа операции
     */
    public OperationType(String name, String description, Long tokenCost, OperationCategory category) {
        this.name = name;
        this.description = description;
        this.tokenCost = tokenCost;
        this.category = category;
    }

    /**
     * Обновляет стоимость операции
     */
    public void updateCost(Long newTokenCost) {
        this.tokenCost = newTokenCost;
    }

    /**
     * Деактивирует тип операции
     */
    public void deactivate() {
        this.isActive = false;
    }

    /**
     * Активирует тип операции
     */
    public void activate() {
        this.isActive = true;
    }

    /**
     * Проверяет, является ли операция бесплатной
     */
    public boolean isFree() {
        return tokenCost == 0L;
    }
}
