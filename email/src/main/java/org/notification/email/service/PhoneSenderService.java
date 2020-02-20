package org.notification.email.service;

import java.util.logging.Logger;

import org.notification.email.entity.Notification;
import org.notification.email.entity.Type;
import org.notification.email.repository.SenderRepository;
import org.springframework.stereotype.Component;


@Component
public class PhoneSenderService implements SenderRepository {

    private static final Logger log = Logger.getLogger(Notification.class.toString());

    public void send(Notification notification) {

            log.info("Message sent: " + notification);
    }

    public Type getType() {
        return Type.PHONE;
    }

}