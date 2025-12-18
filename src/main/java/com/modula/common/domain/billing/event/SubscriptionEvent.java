package com.modula.common.domain.billing.event;

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
public class SubscriptionEvent {
    private UUID userId;
    private String planName;      // Free, Start, Pro...
    private Long tokenLimit;      // Лимиты из плана
    private String status;        // ACTIVE, CANCELLED, PAST_DUE
    private LocalDateTime expirationDate; // nextBillingDate
    private LocalDateTime eventTimestamp;
}