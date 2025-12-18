package com.modula.common.domain.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {

    private UUID id;
    private UUID userId;

    // Эти поля нужны Core Builder'у для кэша в таблице users
    private String planName;      // "Free", "Start"
    private String status;        // "ACTIVE"
    private Long tokenLimit;      // 1000

    // Доп инфо (опционально)
    private LocalDateTime nextBillingDate;
}