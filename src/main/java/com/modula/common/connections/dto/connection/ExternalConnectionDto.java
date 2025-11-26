package com.modula.common.connections.dto.connection;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.modula.common.connections.dto.connection.impl.ApiKeyExternalConnectionDto;
import com.modula.common.connections.dto.connection.impl.BasicExternalConnectionDto;
import com.modula.common.connections.dto.connection.impl.NoneExternalConnectionDto;
import com.modula.common.connections.dto.connection.impl.OAuth2ExternalConnectionDto;
import com.modula.common.connections.dto.connection.util.ExternalConnectionResponse;
import lombok.Data;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "external_connection_type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = OAuth2ExternalConnectionDto.class, name = "OAUTH2"),
        @JsonSubTypes.Type(value = ApiKeyExternalConnectionDto.class, name = "API_KEY"),
        @JsonSubTypes.Type(value = BasicExternalConnectionDto.class, name = "BASIC"),
        @JsonSubTypes.Type(value = NoneExternalConnectionDto.class, name = "NONE")
})
public abstract class ExternalConnectionDto implements ExternalConnectionResponse {
    private UUID id;
    private String name;
    private UUID providerId;
    private UUID userId;
    private UUID workspaceId;
    private Map<String, String> connectionAdditionalParams = new HashMap<>();
    private Boolean connected;
}
