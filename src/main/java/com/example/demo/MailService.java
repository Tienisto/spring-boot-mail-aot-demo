package com.example.demo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private final String sender;

    private final String recipient;

    private final JavaMailSender mailSender;

    public MailService(
        @Value("${spring.mail.username}") String sender,
        @Value("${mail.recipient}") String recipient,
        JavaMailSender mailSender
    ) {
        this.sender = sender;
        this.recipient = recipient;
        this.mailSender = mailSender;
    }

    public void sendMail() throws MessagingException {
        final MimeMessage message = mailSender.createMimeMessage();
        final MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(sender);
        helper.setTo(recipient);
        helper.setSubject("My Subject");
        helper.setText("Hello World");

        mailSender.send(message);
    }
}
