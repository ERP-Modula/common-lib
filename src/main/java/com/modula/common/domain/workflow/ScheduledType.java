package com.modula.common.domain.workflow;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ScheduledType {
    REGULAR_INTERVAL,
    ONCE,
    EVERY_DAY,
    DAYS_OF_WEEK,
    DAYS_OF_THE_MONTH,
    SPECIFIC_DAYS
}
