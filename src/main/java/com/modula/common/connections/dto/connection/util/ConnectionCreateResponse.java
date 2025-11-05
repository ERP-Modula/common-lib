package com.modula.common.connections.dto.connection.util;

import com.modula.common.connections.dto.connection.ExternalConnectionDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO для ответа создания подключения с результатом тестирования.
 * Содержит информацию о созданном подключении и результат его проверки.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectionCreateResponse implements ExternalConnectionResponse {
    
    /**
     * Созданное подключение (может быть null для OAuth2 до завершения потока).
     */
    private ExternalConnectionDto connection;
    
    /**
     * Результат тестирования подключения (может быть null для OAuth2 до завершения потока).
     */
    private ConnectionTestResponse testResult;
    
    /**
     * URL для OAuth2 авторизации (только для OAuth2 подключений до завершения потока).
     */
    private String oauthUrl;

    /**
     * Создает успешный ответ для API_KEY подключения.
     *
     * @param connection созданное подключение
     * @param testResult результат тестирования
     * @return ConnectionCreateResponse с подключением и результатом тестирования
     */
    public static ConnectionCreateResponse success(ExternalConnectionDto connection, ConnectionTestResponse testResult) {
        return ConnectionCreateResponse.builder()
                .connection(connection)
                .testResult(testResult)
                .build();
    }

    /**
     * Создает ответ с ошибкой тестирования (для отката создания).
     *
     * @param testResult результат тестирования с ошибкой
     * @return ConnectionCreateResponse только с результатом тестирования (connection = null)
     */
    public static ConnectionCreateResponse testFailed(ConnectionTestResponse testResult) {
        return ConnectionCreateResponse.builder()
                .testResult(testResult)
                .build();
    }

    /**
     * Создает ответ для OAuth2 потока (до завершения авторизации).
     *
     * @param oauthUrl URL для авторизации
     * @return ConnectionCreateResponse с oauthUrl
     */
    public static ConnectionCreateResponse oauth2Redirect(String oauthUrl) {
        return ConnectionCreateResponse.builder()
                .oauthUrl(oauthUrl)
                .build();
    }

    /**
     * Создает успешный ответ для завершенного OAuth2 подключения.
     *
     * @param connection созданное подключение
     * @param testResult результат тестирования
     * @return ConnectionCreateResponse с подключением и результатом тестирования
     */
    public static ConnectionCreateResponse oauth2Success(ExternalConnectionDto connection, ConnectionTestResponse testResult) {
        return ConnectionCreateResponse.builder()
                .connection(connection)
                .testResult(testResult)
                .build();
    }
}

