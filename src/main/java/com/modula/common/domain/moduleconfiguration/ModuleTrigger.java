package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**
 * Represents a webhook trigger that the module listens to.
 * A trigger is typically called by an external system to notify the platform
 * of an event (e.g., "Task Created", "User Invited").
 */
@Getter
@Entity
public class ModuleTrigger {

    /**
     * Unique identifier for the trigger.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Type of trigger (e.g., WEBHOOK, POLLING).
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TriggerType type;

    /**
     * System name of the trigger (e.g., "onTaskCreated").
     */
    @Column(nullable = false)
    private String name;

    /**
     * Human-readable label (e.g., "On Task Created").
     */
    @Column(nullable = false)
    private String label;

    /**
     * Description shown in the UI to help users understand what this trigger does.
     */
    private String description;

    private final String handlerType = "TRIGGER";
    /**
     * Category used for grouping in the UI (e.g., "tasks", "notifications").
     */
    private String category;

    /**
     * URL external system API for subscribe our service webhook.
     */
    private String webhookSubscribeUrl;
    /**
     * URL external system API for unsubscribe our service webhook.
     */
    private String webhookUnsubscribeUrl;

    /**
     * List of scopes required for this trigger to be invoked.
     */
    @ElementCollection
    @Column(nullable = false)
    private List<String> scopes;

    /**
     * List of fields that the webhook payload returns.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OutputInterface> outputInterface;

    /**
     * List of parameters used to configure the trigger (e.g., filters, event
     * types).
     */
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<InputParameter> inputParameters;
}
