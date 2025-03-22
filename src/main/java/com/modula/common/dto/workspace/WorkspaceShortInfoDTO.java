package com.modula.common.dto.workspace;

import lombok.Data;

import java.util.Date;

@Data
public class WorkspaceShortInfoDTO {
    private String id;
    private String name;
    private String description;
    private boolean favorite;
    private Date lastEdit;
    private int workflowsCount;
    private String workspaceIconPath;
}
