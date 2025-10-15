package com.modula.common.domain.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для ответа валидации токенов.
 * Используется в core-builder и core-processor для передачи информации о
 * валидации и списании токенов.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenValidationResponseDTO {

    /**
     * Статус операции (SUCCESS, FAILED, INSUFFICIENT_TOKENS, etc.)
     */
    private String status;

    /**
     * Сообщение о результате операции
     */
    private String message;

    /**
     * Количество токенов, которое было списано за операцию
     */
    private Long tokensUsed;
}
