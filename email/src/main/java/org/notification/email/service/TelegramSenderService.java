package org.notification.email.service;

import java.util.logging.Logger;

import org.notification.email.entity.Notification;
import org.springframework.stereotype.Service;

@Service("telegramSender")
public class TelegramSenderService {

    private static final Logger log = Logger.getLogger(Notification.class.toString());

    public void sendTelegram(Notification notification){

        log.info("Message sent: " + notification);

    }

}