package com.modula.common.email.dto;

public record EmailBody(String subject, String text, EmailBodyType type) {
}
