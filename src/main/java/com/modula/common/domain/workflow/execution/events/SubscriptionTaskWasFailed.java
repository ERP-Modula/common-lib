package com.modula.common.domain.workflow.execution.events;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

/**
 * Событие, информирующее core-processor о том, что операция подписки или отписки от триггера завершилась с ошибкой.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionTaskWasFailed {

    /**
     * ID воркфлоу, для которого произошла ошибка.
     */
    private UUID workflowId;

    /**
     * Имя модуля, в котором произошла ошибка.
     */
    private String moduleName;

    /**
     * Имя триггера, для которого произошла ошибка.
     */
    private String triggerName;

    /**
     * JSON-объект, содержащий детали ошибки.
     */
    private JsonNode errorMessage;

    private TriggerSubscriptionAction action;
}