package com.modula.common.domain.connection;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Connection {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private UUID appId;

    @ElementCollection
    private List<String> scopes;
}
