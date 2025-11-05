package com.modula.common.connections.dto.connection.util;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для ответа тестирования подключения.
 * Содержит статус тестирования, информацию об ошибке (если есть) и результат выполнения (если успешно).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectionTestResponse {
    
    /**
     * Статус тестирования подключения.
     */
    private TestStatus status;
    
    /**
     * Код ошибки (если тестирование завершилось с ошибкой).
     */
    private String errorCode;
    
    /**
     * Сообщение о результате тестирования.
     */
    private String message;
    
    /**
     * Результат выполнения тестового action (если тестирование успешно).
     */
    private JsonNode result;

    /**
     * Статусы тестирования подключения.
     */
    public enum TestStatus {
        SUCCESS,
        ERROR
    }

    /**
     * Создает успешный ответ.
     *
     * @param message сообщение об успехе
     * @param result  результат выполнения тестового action
     * @return успешный ConnectionTestResponse
     */
    public static ConnectionTestResponse success(String message, JsonNode result) {
        return ConnectionTestResponse.builder()
                .status(TestStatus.SUCCESS)
                .message(message)
                .result(result)
                .build();
    }

    /**
     * Создает ответ с ошибкой.
     *
     * @param message   сообщение об ошибке
     * @param errorCode  код ошибки (может быть null)
     * @return ConnectionTestResponse с ошибкой
     */
    public static ConnectionTestResponse error(String message, String errorCode) {
        return ConnectionTestResponse.builder()
                .status(TestStatus.ERROR)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    /**
     * Создает ответ с ошибкой без кода ошибки.
     *
     * @param message сообщение об ошибке
     * @return ConnectionTestResponse с ошибкой
     */
    public static ConnectionTestResponse error(String message) {
        return error(message, null);
    }
}

