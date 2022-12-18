package com.example.demo;

import jakarta.mail.MessagingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final MailService mailService;

    public MyController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/")
    public void sendMail() throws MessagingException {
        mailService.sendMail();
    }
}
