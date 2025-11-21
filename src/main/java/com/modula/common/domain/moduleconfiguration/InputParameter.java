package com.modula.common.domain.moduleconfiguration;

import com.modula.common.domain.moduleconfiguration.parameter.ParameterDependency;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Type;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity
@Getter
public class InputParameter {

    /**
     * Unique identifier of the input parameter.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * System name of the parameter (e.g., "user_id").
     * Used for internal mapping and referencing in payloads.
     */
    private String name;

    /**
     * Human-readable label (e.g., "User ID").
     * Shown in the UI as the field label.
     */
    private String label;

    /**
     * Indicates whether the parameter is required to proceed.
     */
    private Boolean required;

    /**
     * Help text or tooltip to guide the user.
     */
    private String help;

    /**
     * Type of the parameter (e.g., STRING, NUMBER, SELECT).
     */
    @Enumerated(EnumType.STRING)
    private ParamType type;

    /**
     * Optional list of selectable options.
     * Used when the parameter type is SELECT or similar.
     * Each option may contain nested input parameters.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NestedFieldOption> options;

    /**
     * Nested parameters for complex types (e.g., OBJECT or COLLECTION).
     * This enables recursive specification of structured input.
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputParameter> spec;

    /**
     * If true, options should be fetched dynamically at runtime using
     * optionsEndpointUrl and parsing configuration below.
     */
    private Boolean dynamicOptions;

    /**
     * Relative endpoint URL to fetch dynamic options from (e.g., "/models").
     * Will be resolved against module REST API base URL.
     */
    private String optionsEndpointUrl;

    /**
     * HTTP method to fetch options (GET/POST). Defaults to GET if null.
     */
    private String optionsHttpMethod;

    /**
     * JSONPath to the array in response that contains items (e.g., "$.data").
     */
    private String optionsDataJsonPath;

    /**
     * Field name inside each item for the option value (e.g., "id").
     */
    private String optionsValueField;

    /**
     * Field name inside each item for the option label (e.g., "id" or "name").
     */
    private String optionsLabelField;

    /**
     * ID действия (ModuleAction), которое нужно выполнить для получения динамических опций.
     * Более гибкая альтернатива optionsEndpointUrl.
     */
    @Column(name = "options_action_id")
    private UUID optionsActionId;

    /**
     * Определяет, какие параметры из UI нужно передать в тело/параметры
     * запроса для получения динамических опций.
     * Формат: { "параметр_в_запросе": "${имя_параметра_в_UI}" }
     * Пример: { "spreadsheetId": "${spreadsheetId}" }
     */
    @Type(JsonBinaryType.class)
    @Column(name = "options_request_params", columnDefinition = "jsonb")
    private Map<String, String> optionsRequestParams;

    /**
     * Список правил, определяющих видимость и обязательность этого параметра
     * в зависимости от значений других параметров.
     */
    @Type(JsonBinaryType.class)
    @Column(columnDefinition = "jsonb")
    private List<ParameterDependency> dependencies;
}