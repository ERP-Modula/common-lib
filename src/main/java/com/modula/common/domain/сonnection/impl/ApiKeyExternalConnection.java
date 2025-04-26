package com.modula.common.domain.сonnection.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import modula.com.core_builder.connections.entity.ExternalConnection;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "api_key_external_connection")
public class ApiKeyExternalConnection extends ExternalConnection {
    @Column(name = "api_key")
    private String apiKey;
}
