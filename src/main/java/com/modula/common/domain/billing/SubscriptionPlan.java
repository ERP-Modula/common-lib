package com.modula.common.domain.billing;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * План подписки, определяющий тарифный план пользователя.
 * Включает как стандартные планы (Free, Start, Business, Premium),
 * так и кастомные планы для партнеров.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Название плана (Free, Start, Business, Premium, Custom)
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Описание плана
     */
    private String description;

    /**
     * Стоимость плана в рублях
     */
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    /**
     * Период биллинга
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillingPeriod billingPeriod;

    /**
     * Лимит токенов в периоде (null = безлимитно)
     */
    private Long tokenLimit;

    /**
     * Активен ли план
     */
    @Column(nullable = false)
    private boolean isActive = true;

    /**
     * Кастомный ли план (для партнеров)
     */
    @Column(nullable = false)
    private boolean isCustom = false;

    /**
     * Список возможностей плана
     */
    @ElementCollection
    private List<String> features;

    /**
     * Дата создания плана
     */
    @Column(nullable = false)
    private ZonedDateTime createdAt = ZonedDateTime.now();

    /**
     * Дата последнего обновления
     */
    private ZonedDateTime updatedAt;

    /**
     * Создание нового плана подписки
     */
    public SubscriptionPlan(String name, String description, BigDecimal price,
            BillingPeriod billingPeriod, Long tokenLimit, boolean isCustom) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.billingPeriod = billingPeriod;
        this.tokenLimit = tokenLimit;
        this.isCustom = isCustom;
        this.createdAt = ZonedDateTime.now();
    }

    /**
     * Проверяет, является ли план безлимитным
     */
    public boolean isUnlimited() {
        return tokenLimit == null;
    }

    /**
     * Обновляет информацию о плане
     */
    public void updatePlan(String name, String description, BigDecimal price,
            BillingPeriod billingPeriod, Long tokenLimit, List<String> features) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.billingPeriod = billingPeriod;
        this.tokenLimit = tokenLimit;
        this.features = features;
        this.updatedAt = ZonedDateTime.now();
    }

    /**
     * Деактивирует план
     */
    public void deactivate() {
        this.isActive = false;
        this.updatedAt = ZonedDateTime.now();
    }
}
