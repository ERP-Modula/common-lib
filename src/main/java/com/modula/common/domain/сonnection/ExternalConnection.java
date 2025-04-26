package com.modula.common.domain.сonnection;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@Entity
@Table(name = "external_connection")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class ExternalConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "connection_params", columnDefinition = "jsonb")
//    @Convert(converter = ConnectionParamsConverter.class)
    private Map<String, Object> connectionParams = new HashMap<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "сonnected")
    private Boolean connected;
}
