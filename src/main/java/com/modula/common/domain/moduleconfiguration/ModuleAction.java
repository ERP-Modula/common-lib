package com.modula.common.domain.moduleconfiguration;

import com.modula.common.utils.ActionHttpMethodType;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**
 * Represents an individual API action that a module can perform.
 * This maps to a specific endpoint relative to the module's REST API base URL.
 * Each action can define required input parameters, expected output interface,
 * HTTP method type, and security scopes.
 */
@Entity
@Getter
public class ModuleAction {

    /**
     * Unique identifier for the module action.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * System name of the action (e.g., "createTask", "sendEmail").
     */
    @Column(nullable = false)
    private String name;

    /**
     * Human-readable label for UI display (e.g., "Create Task").
     */
    @Column(nullable = false)
    private String label;

    /**
     * Description of the action, typically shown as tooltip or help text.
     */
    private String description;

    /**
     * Action Link to Modula help center WIKI.
     */
    private String documentationSource;

    /**
     * Category of the action, used for grouping in UI (e.g., "tasks", "messages").
     */
    private String category;

    /**
     * Relative URL for the endpoint.
     * Will be appended to ModuleConfiguration.restApiBaseUrl.
     * Example: "/tasks.task.add"
     */
    private String endpointUrl;

    private final String handlerType = "ACTION";

    /**
     * HTTP method used to call the action (e.g., GET, POST, PUT).
     */
    @Enumerated(EnumType.STRING)
    private ActionHttpMethodType methodType;

    /**
     * List of required security scopes for this action (OAuth, API key, etc).
     */
    @ElementCollection
    private List<String> scopes;

    /**
     * List of fields returned by this action.
     * Used to define the structure of the API response.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputInterface> outputInterface;

    /**
     * List of input parameters required to invoke this action.
     * Defines request body or query parameters depending on method type.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<InputParameter> inputParameters;
}