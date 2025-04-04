package com.modula.common.domain.workflow;

import jakarta.annotation.Nullable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Embeddable
@Getter
@NoArgsConstructor
public class SchedulerSettings {
    @Nullable
    private Long interval;
    @Nullable
    private ZonedDateTime onceRunningDate;
    @Nullable
    private String time;
    @Nullable
    @ElementCollection
    private List<Integer> days;
    @Nullable
    @ElementCollection
    private List<Integer> months;
    private ScheduledType scheduledType;
}

