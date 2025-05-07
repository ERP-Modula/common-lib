package com.modula.common.domain.connection.impl;

import com.modula.common.domain.connection.ExternalConnection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a connection to an external system using Basic Authentication.
 * Stores the login and password required to authenticate API calls.
 * Extends {@link ExternalConnection}.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "basic_external_connection")
public class BasicExternalConnection extends ExternalConnection {

    /**
     * Login or username used for Basic Authentication.
     */
    @Column(name = "login")
    private String login;

    /**
     * Password used for Basic Authentication.
     * This field should be securely stored and never exposed in API responses.
     */
    @Column(name = "password")
    private String password;
}
