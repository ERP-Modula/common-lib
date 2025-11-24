package com.modula.common.domain.workflow;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;
import java.util.List;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerSettings {
    @Nullable
    private Long interval;

    @Nullable
    private ZonedDateTime onceRunningDate;

    @Nullable
    private String time;

    @Nullable
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "workflow_days", joinColumns = @JoinColumn(name = "workflow_id"))
    @Column(name = "day")
    private List<Integer> days;

    @Nullable
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "workflow_months", joinColumns = @JoinColumn(name = "workflow_id"))
    @Column(name = "month")
    private List<Integer> months;

    @Enumerated(EnumType.STRING)
    private ScheduledType scheduledType;
}