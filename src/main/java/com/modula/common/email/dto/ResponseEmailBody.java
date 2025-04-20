package com.modula.common.email.dto;

import jakarta.mail.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public record ResponseEmailBody(String subject, List<String> from, String body, String bodyType) {
    public ResponseEmailBody(Message message) throws MessagingException, IOException {
        this(message.getSubject(),
                Arrays.stream(message.getFrom()).map(Address::toString).toList(),
                getText(message),
                message.getContentType());
    }

    private static String getText(Message message) throws MessagingException, IOException {
        StringBuilder textCollector = new StringBuilder();
        collectTextFromMessage(textCollector, message);
        return textCollector.toString();
    }

    private static void collectTextFromMessage(StringBuilder textCollector, Part part)
            throws MessagingException, IOException {
        if (part.isMimeType("text/plain")) {
            textCollector.append((String) part.getContent());
        } else if (part.isMimeType("multipart/*") && part.getContent() instanceof Multipart) {
            Multipart multiPart = (Multipart) part.getContent();
            for (int i = 0; i < multiPart.getCount(); i++) {
                collectTextFromMessage(textCollector, multiPart.getBodyPart(i));
            }
        }
    }
}
