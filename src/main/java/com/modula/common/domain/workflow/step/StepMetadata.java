package com.modula.common.domain.workflow.step;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StepMetadata {
    @Embedded
    private Location location;
    @Embedded
    private Restore restore;
}
