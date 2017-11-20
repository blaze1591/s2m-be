package com.s2mbe.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendMail(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("salsky.d@gmail.com");
        mailMessage.setSubject("test");
        mailMessage.setText(message);
        emailSender.send(mailMessage);
    }
}
