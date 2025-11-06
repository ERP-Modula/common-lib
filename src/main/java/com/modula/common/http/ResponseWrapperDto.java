package com.modula.common.http;

import com.fasterxml.jackson.annotation.JsonIgnore;
import feign.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DTO для передачи ResponseWrapper через REST API.
 * Содержит только сериализуемые данные из feign.Response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseWrapperDto {

    /**
     * HTTP статус код ответа.
     */
    private int status;

    /**
     * HTTP заголовки ответа.
     */
    private Map<String, List<String>> headers;

    /**
     * Тело ответа в виде строки (если доступно).
     */
    private String body;

    /**
     * Создает ResponseWrapperDto из ResponseWrapper.
     * 
     * @param responseWrapper исходный ResponseWrapper
     * @return ResponseWrapperDto с данными из Response
     */
    public static ResponseWrapperDto fromResponseWrapper(ResponseWrapper responseWrapper) {
        if (responseWrapper == null || responseWrapper.getResponse() == null) {
            return null;
        }

        Response response = responseWrapper.getResponse();
        
        // Извлекаем заголовки
        Map<String, List<String>> headersMap = new HashMap<>();
        if (response.headers() != null) {
            response.headers().forEach((key, values) -> {
                headersMap.put(key, values.stream().collect(Collectors.toList()));
            });
        }

        // Извлекаем тело ответа
        String bodyText = null;
        try {
            if (response.body() != null) {
                byte[] bodyBytes = response.body().asInputStream().readAllBytes();
                bodyText = new String(bodyBytes, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            // Если не удалось прочитать тело, оставляем null
        }

        return ResponseWrapperDto.builder()
                .status(response.status())
                .headers(headersMap)
                .body(bodyText)
                .build();
    }

    /**
     * Создает ResponseWrapper из ResponseWrapperDto.
     * Примечание: это не полная реконструкция, так как Response требует InputStream.
     * Используется только для передачи данных, не для восстановления исходного Response.
     */
    @JsonIgnore
    public ResponseWrapper toResponseWrapper() {
        // Это не может быть полностью реализовано, так как Response требует InputStream
        // и другие несериализуемые компоненты
        throw new UnsupportedOperationException(
                "ResponseWrapperDto cannot be converted back to ResponseWrapper. " +
                "Use ResponseWrapper directly for internal operations.");
    }
}
