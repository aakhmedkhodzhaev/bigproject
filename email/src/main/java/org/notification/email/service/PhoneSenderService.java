package org.notification.email.service;


import org.notification.email.entity.Notifications;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("phoneSenders")
public class PhoneSenderService {

    private static final Logger log = Logger.getLogger(Notifications.class.toString());

    public void sendSMS(Notifications notifications){

        log.info("Message sent: " + notifications);

    }

}