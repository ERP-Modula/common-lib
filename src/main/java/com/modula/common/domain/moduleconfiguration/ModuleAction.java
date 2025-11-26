package com.modula.common.domain.moduleconfiguration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.modula.common.domain.billing.OperationType;
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

    @Column(name = "handler_type", nullable = false)
    private String handlerType;

    /**
     * HTTP method used to call the action (e.g., GET, POST, PUT).
     */
    @Enumerated(EnumType.STRING)
    private ActionHttpMethodType methodType;

    /**
     * List of required security scopes for this action (OAuth, API key, etc).
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "module_action_scopes", joinColumns = @JoinColumn(name = "module_action_id"))
    @Column(name = "scope", nullable = false)
    private List<String> scopes;

    /**
     * Expected response type for this action.
     * Determines how the response should be handled (JSON, binary, text, etc.).
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResponseType responseType = ResponseType.JSON;

    /**
     * List of preview configurations for this action.
     * Defines how the action's output should be displayed in preview mode.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PreviewConfig> previewConfigs;

    /**
     * List of input parameters required to invoke this action.
     * Defines request body or query parameters depending on method type.
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<InputParameter> inputParameters;

    /**
     * Type of operation for billing purposes.
     * Determines the cost in tokens for executing this action.
     */
    @ManyToOne()
    @JoinColumn(name = "operation_type_id", nullable = false)
    @JsonIgnore
    private OperationType operationType;

    @Column(name = "supports_pagination", nullable = false)
    private boolean supportsPagination = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "pagination_strategy", nullable = false)
    private PaginationStrategy paginationStrategy = PaginationStrategy.NONE;

    @Column(name = "items_json_path")       private String itemsJsonPath;
    @Column(name = "next_page_json_path")   private String nextPageJsonPath;
    @Column(name = "next_link_header_name") private String nextLinkHeaderName;

    @Column(name = "default_page_size") private Integer defaultPageSize;
    @Column(name = "max_page_size")     private Integer maxPageSize;

    @Column(name = "limit_param_name")  private String limitParamName;
    @Column(name = "offset_param_name") private String offsetParamName;
    @Column(name = "page_param_name")   private String pageParamName;
    @Column(name = "cursor_param_name") private String cursorParamName;
}