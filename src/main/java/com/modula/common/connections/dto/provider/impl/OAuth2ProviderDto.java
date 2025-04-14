package com.modula.common.connections.dto.provider.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.modula.common.connections.dto.provider.ProviderDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@Data
public class OAuth2ProviderDto extends ProviderDto {
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("client_secret")
    private String clientSecret;
    @JsonProperty("code_uri")
    private String codeUri;
    @JsonProperty("token_uri")
    private String tokenUri;
    @JsonProperty("extra_query_params")
    private Map<String, String> extraQueryParams;
}
