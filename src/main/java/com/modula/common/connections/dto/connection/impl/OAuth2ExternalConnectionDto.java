package com.modula.common.connections.dto.connection.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modula.common.connections.dto.connection.ExternalConnectionDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class OAuth2ExternalConnectionDto extends ExternalConnectionDto {
    private Set<String> scopes;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("token_type")
    private String tokenType;
}
