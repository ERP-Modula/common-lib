package com.modula.common.connections.dto.connection.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modula.common.connections.dto.connection.ExternalConnectionDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiKeyExternalConnectionDto extends ExternalConnectionDto {
    @JsonProperty("api_key")
    private String apiKey;
}
