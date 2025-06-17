package com.modula.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModulaApiResponse {
    private boolean success;
    private String message;

    public static ModulaApiResponse success(String message) {
        return ModulaApiResponse.builder()
                .success(true)
                .message(message)
                .build();
    }
}
