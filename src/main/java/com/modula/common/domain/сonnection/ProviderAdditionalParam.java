package com.modula.common.domain.сonnection;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class ProviderAdditionalParam {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "param_key", nullable = false)
    private String key; // Например: "domain"

    @Column(name = "param_value_source", nullable = false)
    private String valueSource; // Путь к значению, например: "connection.customDomain"

    @Column(name = "label", nullable = false)
    private String label; // Человекочитаемое название: "Домен Bitrix"

    @Column(name = "description")
    private String description; // Подсказка: "Укажите поддомен вашего Bitrix24"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;
}
