package com.modula.common.domain.workflow.execution.events;

import com.modula.common.connections.dto.connection.ExternalConnectionDto;
import com.modula.common.domain.workflow.Workflow;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Универсальное событие, инициирующее подписку или отписку от триггера.
 * Отправляется из core-processor при активации/деактивации воркфлоу.
 * Это событие самодостаточно и содержит всю необходимую информацию.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TriggerSubscriptionTask {

    /**
     * Действие, которое необходимо выполнить (подписаться или отписаться).
     */
    private TriggerSubscriptionAction action;

    /**
     * Воркфлоу, для которого выполняется действие.
     */
    private Workflow workflow;

    /**
     * Полные данные о подключении, используемом для подписки.
     */
    private ExternalConnectionDto connection;

    /**
     * Параметры триггера, настроенные пользователем в UI.
     */
    private Map<String, Object> triggerParams;
}