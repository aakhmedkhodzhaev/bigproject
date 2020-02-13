package org.notification.email.service;

import java.util.logging.Logger;

import org.notification.email.entity.Notification;
import org.springframework.stereotype.Service;

@Service("phoneSenders")
public class PhoneSenderService {

    private static final Logger log = Logger.getLogger(Notification.class.toString());

    public void sendSMS(Notification notification){

        log.info("Message sent: " + notification);

    }

}