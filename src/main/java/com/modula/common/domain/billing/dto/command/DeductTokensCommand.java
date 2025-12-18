package com.modula.common.domain.billing.dto.command;

import java.util.UUID;

public record DeductTokensCommand(
        UUID userId,
        Long amount,
        String operationType,
        String description
) {}