package org.notification.email.service;

import java.util.logging.Logger;

import org.notification.email.entity.Notifications;
import org.springframework.stereotype.Service;

@Service("phoneSenders")
public class PhoneSenderService {

    private static final Logger log = Logger.getLogger(Notifications.class.toString());

    public void sendSMS(Notifications notifications){

        log.info("Message sent: " + notifications);

    }

}