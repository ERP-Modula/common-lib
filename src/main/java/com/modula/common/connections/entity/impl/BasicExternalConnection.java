package com.modula.common.connections.entity.impl;

import com.modula.common.connections.entity.ExternalConnection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
