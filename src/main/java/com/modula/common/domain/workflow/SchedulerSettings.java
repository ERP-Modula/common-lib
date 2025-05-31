package com.modula.common.domain.workflow;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
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
    private ZonedDateTime onceRunningDate; // timestamp
    @Nullable
    private String time;
    @Nullable
    @ElementCollection
    private List<Integer> days;
    @Nullable
    @ElementCollection
    private List<Integer> months;
    @Enumerated(EnumType.STRING)
    private ScheduledType scheduledType;
}

