package com.modula.common.domain.step;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Restore {
    @ElementCollection
    private Map<String, String> parameters;
}