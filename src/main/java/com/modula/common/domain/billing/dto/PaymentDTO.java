package com.modula.common.domain.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private UUID id;
    private BigDecimal amount;
    private String currency;
    private String status;
    private String invoiceId;
    private LocalDateTime date;
    private String failReason;
}