package com.modula.common.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Folder {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "workspace_id")
    private List<Workspace> workspace;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "folder_id")
    private List<Folder> childrenFolders;
}