package com.modula.common.domain.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingTransactionDTO {
    private UUID id;
    private Long amount;
    private String type;
    private String status;
    private String description;
    private LocalDateTime createdAt;
}