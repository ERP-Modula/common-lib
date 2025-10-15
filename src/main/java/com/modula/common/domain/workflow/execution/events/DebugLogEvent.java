package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * Событие для отладки выполнения workflow в реальном времени.
 * Содержит информацию о выполнении шагов, включая токены и детали выполнения.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DebugLogEvent {

    /**
     * Уникальный идентификатор события отладки
     */
    private String id;

    /**
     * ID шага, который выполняется
     */
    private UUID stepId;

    /**
     * ID экземпляра workflow (null для тестов)
     */
    @Nullable
    private UUID workflowInstanceId;

    /**
     * ID сессии WebSocket для отладки
     */
    private String debugSessionId;

    /**
     * Название шага
     */
    private String stepName;

    /**
     * Статус выполнения шага
     */
    private DebugStepStatus status;

    /**
     * Время начала выполнения
     */
    private ZonedDateTime startTime;

    /**
     * Время завершения выполнения (null если еще выполняется)
     */
    @Nullable
    private ZonedDateTime endTime;

    /**
     * Длительность выполнения в миллисекундах
     */
    @Nullable
    private Long duration;

    /**
     * Количество токенов, потраченных на выполнение
     */
    @Nullable
    private Long tokensUsed;

    /**
     * Детали выполнения шага
     */
    private DebugStepDetails details;

    /**
     * Детали выполнения шага
     */
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DebugStepDetails {
        /**
         * URL для HTTP запросов
         */
        @Nullable
        private String url;

        /**
         * HTTP метод
         */
        @Nullable
        private String method;

        /**
         * HTTP статус код ответа
         */
        @Nullable
        private Integer statusCode;

        /**
         * Описание операции
         */
        @Nullable
        private String description;

        /**
         * Входные данные шага
         */
        @Nullable
        private JsonNode input;

        /**
         * Выходные данные шага
         */
        @Nullable
        private JsonNode output;

        /**
         * Полный ответ от внешнего сервиса
         */
        @Nullable
        private JsonNode response;

        /**
         * Сообщение об ошибке
         */
        @Nullable
        private String error;

        /**
         * Стек ошибки
         */
        @Nullable
        private String errorStack;

        /**
         * HTTP заголовки запроса
         */
        @Nullable
        private Map<String, String> headers;

        /**
         * Тело HTTP запроса
         */
        @Nullable
        private JsonNode requestBody;

        /**
         * Тело HTTP ответа
         */
        @Nullable
        private JsonNode responseBody;

        /**
         * Дополнительные метаданные
         */
        @Nullable
        private Map<String, Object> metadata;
    }

    /**
     * Статусы выполнения шага для отладки
     */
    public enum DebugStepStatus {
        /**
         * Шаг начал выполняться
         */
        STARTED,

        /**
         * Шаг успешно завершен
         */
        COMPLETED,

        /**
         * Шаг завершился с ошибкой
         */
        FAILED,

        /**
         * Предупреждение при выполнении шага
         */
        WARNING
    }
}
