package com.modula.common.domain.moduleconfiguration.parameter;

import lombok.Data;
import java.util.List;

@Data
public class ParameterDependency {
    private String sourceParameterName;
    private DependencyConditionType conditionType;
    private VisibilityAction visibilityAction;
    private Object expectedValue;
    private List<Object> expectedValues;
}