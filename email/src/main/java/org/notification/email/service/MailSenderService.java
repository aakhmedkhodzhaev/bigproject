package org.notification.email.service;

import org.notification.email.entity.Notifications;
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
    public void sendEmail(Notifications notifications) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(notifications.getRecipient());
        email.setSubject("email");
        email.setFrom("aakhmedkhodzhaev@gmail.com");
        email.setText(notifications.getMessage());

        javaMailSender.send(email);
    }

}