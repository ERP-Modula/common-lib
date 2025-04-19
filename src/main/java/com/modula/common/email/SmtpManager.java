package com.modula.common.email;

import com.modula.common.email.dto.EmailBody;
import com.modula.common.email.dto.EmailBodyType;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Properties;

public class SmtpManager {
    private static final String SMTP = "smtp";
    private static final int EMAIL_PORT = 587;
    private final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    public static void main(String[] args) throws MessagingException {
        String email = "malyshev.2005n@gmail.com";
        String password = "eand sulf cndf ukoh";
        SmtpManager manager = new SmtpManager("smtp.gmail.com");
        manager.setUsernameAndPassword(email, password);
        EmailBody body = new EmailBody("test with mimeMessage", "<h1>asdf</h1>", EmailBodyType.HTML);
        manager.send(email, password, email, body);
    }

    public SmtpManager(String smtpHost) {
        mailSender.setPort(EMAIL_PORT);
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
