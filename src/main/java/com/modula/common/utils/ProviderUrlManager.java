package com.modula.common.utils;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProviderUrlManager {

    public String resolveUriTemplate(String template, Map<String, String> params) {
        // Используем Apache Commons Text для подстановки значений
        StringSubstitutor substitutor = new StringSubstitutor(params);
        return substitutor.replace(template);
    }
}
