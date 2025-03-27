package com.modula.common.domain.moduleconfiguration;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class OutputInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    @Enumerated(EnumType.STRING)
    private InterfaceFieldType paramTypeEnum;
    private String label;
    private boolean time;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OutputInterface> spec;
}