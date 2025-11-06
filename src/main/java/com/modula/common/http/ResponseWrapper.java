package com.modula.common.http;

import lombok.AllArgsConstructor;
import lombok.Data;
import feign.Response;

/**
 * Универсальная обертка для HTTP ответов, которая может содержать данные разных
 * типов.
 * Используется для передачи ответов от HTTP клиентов к сервисам обработки.
 */
@Data
@AllArgsConstructor
public class ResponseWrapper {

    private final Response response;

    /**
     * Проверяет, является ли ответ успешным (статус 2xx).
     */
    public boolean isSuccess() {
        return response.status() >= 200 && response.status() < 300;
    }

    /**
     * Проверяет, является ли ответ ошибкой (статус >= 400).
     */
    public boolean isError() {
        return response.status() >= 400;
    }

    /**
     * Проверяет, является ли ответ текстовым.
     */
    public boolean isText() {
        return response.headers().get("Content-Type").stream()
                .anyMatch(ct -> ct.contains("text/"));
    }

    /**
     * Проверяет, является ли ответ JSON.
     */
    public boolean isJson() {
        return response.headers().get("Content-Type").stream()
                .anyMatch(ct -> ct.contains("application/json"));
    }
}
