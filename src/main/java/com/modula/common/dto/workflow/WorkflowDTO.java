package com.modula.common.dto.workflow;

import lombok.Data;
import com.modula.common.dto.StepDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class WorkflowDTO {
    private WorkflowShortInfoDTO shortInfo;
    private List<StepDTO> steps = new ArrayList<>();
}
