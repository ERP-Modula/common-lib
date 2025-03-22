package com.modula.common.dto;

import com.modula.common.dto.workflow.WorkflowShortInfoDTO;
import lombok.Data;

import java.util.List;

@Data
public class FolderDTO {
    private String id;
    private String name;
    private List<WorkflowShortInfoDTO> workflows;
    private List<FolderDTO> childrenFolders;
}