package com.modula.common.domain.сonnection;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "oauth2_provider")
public class OAuth2Provider extends Provider {
    @Column(name = "client_id", nullable = false)
    private String clientId;
    @Column(name = "client_secret", nullable = false)
    private String clientSecret;

    @Column(name = "token_uri", nullable = false)
    private String tokenUri;

    @ElementCollection
    @CollectionTable(name = "extra_query_params")
    private Map<String, String> extraQueryParams;
}
