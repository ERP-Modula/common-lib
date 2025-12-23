package com.modula.common.domain.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenBalanceDTO {
    private Long currentBalance;
    private Long totalSpent;
    private Long totalEarned;
}