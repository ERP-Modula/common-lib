package com.modula.common.domain.moduleconfiguration.impl;

import com.modula.common.domain.connection.Provider;
import com.modula.common.domain.moduleconfiguration.AuthType;
import com.modula.common.domain.moduleconfiguration.ModuleConfiguration;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class RestAPIModuleConfiguration extends ModuleConfiguration {

    /**
     * Authentication type used by the module (e.g., OAUTH2, API_KEY).
     */
    @Enumerated(EnumType.STRING)
    private AuthType authType;

    /**
     * Reference to the provider associated with this module.
     */
//  TODO Убрать из реста. приходят вся инфа о подключениях :) взломают
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    /**
     * Base URL for accessing the open REST API.
     * This may contain template variables from the connection.
     * Example: "https://<bitrix_domain>/rest"
     */
    private String restApiBaseUrl;

    /**
     * Base URL for the webhook API.
     * This may also contain template variables from the connection.
     * Example: https://bitrix_domain/webhooks
     */
    private String webhookBaseUrl;
}
