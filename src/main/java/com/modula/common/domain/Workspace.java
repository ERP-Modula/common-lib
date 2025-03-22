package com.modula.common.domain;

import com.modula.common.domain.workflow.Workflow;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Workspace {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String name;
    private String description;
    private boolean favorite;
    private ZonedDateTime lastEdit = ZonedDateTime.now();
    private int workflowsCount;
    private String workspaceIconPath;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "workspace_id")
    private List<Folder> foldersTree;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "workspace_id")
    private List<Workflow> workflows;


    public void addWorkflow(Workflow workflow){
        this.workflows.add(workflow);
    }
}