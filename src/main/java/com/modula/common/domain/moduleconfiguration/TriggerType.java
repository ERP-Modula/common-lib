package com.modula.common.domain.moduleconfiguration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TriggerType {
    WEBHOOK,
    POLLING
}
