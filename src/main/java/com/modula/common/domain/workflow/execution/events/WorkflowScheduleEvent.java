package com.modula.common.domain.workflow.execution.events;

import com.modula.common.domain.workflow.ScheduledType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowScheduleEvent {
    private UUID workflowId;
    private UUID workspaceId;
    private ScheduleAction action;

    private ScheduledType scheduledType;
    private Long interval;
    private ZonedDateTime onceRunningDate;
    private String time; // "HH:mm"
    private List<Integer> days;
    private List<Integer> months;
}