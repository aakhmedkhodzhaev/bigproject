package org.notification.email.service;

import java.util.logging.Logger;

import org.notification.email.entity.Notifications;
import org.springframework.stereotype.Service;

@Service("telegramSender")
public class TelegramSenderService {

    private static final Logger log = Logger.getLogger(Notifications.class.toString());

    public void sendTelegram(Notifications notifications){

        log.info("Message sent: " + notifications);

    }

}