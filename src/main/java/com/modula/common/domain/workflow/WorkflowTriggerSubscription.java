package com.modula.common.domain.workflow;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modula.common.domain.connection.ExternalConnection;
import com.modula.common.domain.moduleconfiguration.ModuleTrigger;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class WorkflowTriggerSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Триггер, на который подписан Workflow
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trigger_id", nullable = false)
    private ModuleTrigger trigger;

    /**
     * Подключение, используемое для этой подписки
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "external_connection_id")
    private ExternalConnection connection;

    /**
     * Workflow, который подписан на триггер
     */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "workflow_id", nullable = false)
    private Workflow workflow;

    /**
     * Внешний ID подписки (если API сервиса возвращает его)
     */
    private String externalSubscriptionId;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> triggerParams;

    public WorkflowTriggerSubscription(
            ModuleTrigger trigger,
            ExternalConnection connection,
            Workflow workflow
    ) {
        this.trigger = trigger;
        this.connection = connection;
        this.workflow = workflow;
    }

    public void setTriggerParams(Map<String, Object> triggerParams) {
        this.triggerParams = triggerParams;
    }
}