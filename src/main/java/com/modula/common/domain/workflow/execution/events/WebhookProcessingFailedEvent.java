package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Событие, информирующее о том, что integration-modules получил,
 * но не смог обработать (например, распарсить) входящий вебхук.
 * Отправляется из integration-modules в core-processor.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebhookProcessingFailedEvent {

    /**
     * Имя модуля, который получил вебхук.
     */
    private String moduleName;

    /**
     * ID подключения, если его удалось определить (актуально для pull-based модулей).
     * Может быть null.
     */
    private UUID connectionId;

    /**
     * Причина ошибки, понятная для пользователя.
     */
    private String reason;

    /**
     * Фрагмент тела запроса (payload) для помощи в отладке.
     * (Обрезан до ~500 символов для безопасности и компактности).
     */
    private String payloadSnippet;

    /**
     * Дополнительные детали, например, тип исключения.
     */
    private JsonNode errorDetails;
}