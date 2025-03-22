package com.modula.common.dto.workflow;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WorkflowShortInfoDTO {
    private String id;
    private String name;
    private String description;
    private boolean enable;
    private int interval;
    private String type;
    private boolean isActive;
    private boolean isArchived;
    private List<String> usedModules;
    private Date created;
    private String createdByUserId;
    private Date lastEdit;
    private String updatedByUserId;
    private int executionCount;
    private Date lastExecution;
}