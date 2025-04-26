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
@Table(name = "basic_external_connection")
public class BasicExternalConnection extends ExternalConnection {
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
}
