package org.notification.email.service;

import org.notification.email.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("mailSenders")
public class MailSenderService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailSenderService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendEmail(Notification notification) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(notification.getRecipient());
        email.setSubject("email");
        email.setFrom("aakhmedkhodzhaev@gmail.com");
        email.setText(notification.getMessage());

        javaMailSender.send(email);
    }

}