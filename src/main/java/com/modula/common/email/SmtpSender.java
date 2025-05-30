package com.modula.common.email;

import com.modula.common.email.dto.EmailBody;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Properties;

public class SmtpSender {
    private static final String SMTP = "smtp";
    private static final int SMTP_PORT = 587;
    private final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    public SmtpSender(String smtpHost) {
        mailSender.setPort(SMTP_PORT);
        mailSender.setHost(smtpHost);
        mailSender.setProtocol(SMTP);
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", SMTP);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.starttls.required", "true");
        properties.put("mail.debug", "true");
    }

    public void send(String senderEmail, String password, String recipientEmail, EmailBody body)
            throws MessagingException {
        switch (body.type()) {
            case HTML:
                send(senderEmail, password, buildMimeMessage(senderEmail, recipientEmail, body));
                break;
            case PLAIN_TEXT:
                send(senderEmail, password, buildSimpleMailMessage(senderEmail, recipientEmail, body));
                break;
        }
    }

    public void send(String email, String password, SimpleMailMessage message) {
        setUsernameAndPassword(email, password);
        mailSender.send(message);
    }

    public void send(String email, String password, MimeMessage message) {
        setUsernameAndPassword(email, password);
        mailSender.send(message);
    }

    public void setUsernameAndPassword(String email, String password) {
        mailSender.setUsername(email);
        mailSender.setPassword(password);
    }

    public MimeMessage buildMimeMessage(String senderEmail, String recipientEmail, EmailBody body)
            throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(senderEmail);
        helper.setTo(recipientEmail);
        helper.setSubject(body.subject());
        helper.setText(body.text(), true);
        return message;
    }

    public SimpleMailMessage buildSimpleMailMessage(String senderEmail, String recipientEmail, EmailBody body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setSubject(body.subject());
        message.setTo(recipientEmail);
        message.setText(body.text());
        return message;
    }
}
