package com.example.myproject.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    public JavaMailSenderImpl mailSender;

    public void sendCredentials(String toEmail, String userId, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Your Registration Credentials");
        message.setText("Welcome!\n\nUser ID: " + userId + "\nPassword: " + password + "\n\nPlease login and change your password.");

        mailSender.send(message);
    }

}
