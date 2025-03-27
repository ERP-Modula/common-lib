package com.modula.common.domain.moduleconfiguration;

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
public class TriggerSettings {
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

