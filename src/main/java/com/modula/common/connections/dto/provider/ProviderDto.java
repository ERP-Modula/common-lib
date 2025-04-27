package com.modula.common.connections.dto.provider;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.modula.common.connections.dto.provider.impl.OAuth2ProviderDto;
import com.modula.common.domain.moduleconfiguration.AuthType;
import com.modula.common.domain.сonnection.ProviderAdditionalParam;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "auth_type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OAuth2ProviderDto.class, name = "OAUTH2"),
        @JsonSubTypes.Type(value = ProviderDto.class, name = "BASIC"),
        @JsonSubTypes.Type(value = ProviderDto.class, name = "API_KEY")
})
public class ProviderDto {
    private UUID id;
    private String name;
    private String codeUri;
    private String label;
    private String description;
    private String alertNotification;
    private List<ProviderAdditionalParam> additionalParams;
    private AuthType authType;
}
