package org.notification.email.service;

import org.notification.email.entity.Notification;
import org.notification.email.entity.Status;
import org.notification.email.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ScheduledTasks")
public class ScheduledTasksService {

        private final NotificationService nsService;
        private final MailSenderService msService;
        private final PhoneSenderService psService;
        private final TelegramSenderService tsService;

    @Autowired
    public ScheduledTasksService(NotificationService nsService, MailSenderService msService, PhoneSenderService psService, TelegramSenderService tsService) {
        this.nsService = nsService;
        this.msService = msService;
        this.psService = psService;
        this.tsService = tsService;
    }

        @Async
        @Scheduled(cron="0 0/5 * 1/1 * *")
        public void sentNotifications(){

            List<Notification> nList = nsService.findBystatusValue();

            for(Notification notification : nList) {
                if(notification.getNotificationType()==Type.EMAIL){
                    try{
                        msService.sendEmail(notification);
                        notification.setStatusValue(Status.SENT);
                        nsService.saveNotify(notification);

                    } catch(Exception e){
                        e.getStackTrace();
                        notification.setStatusValue(Status.ERRORS);
                        nsService.saveNotify(notification);
                    }
                }
                else if(notification.getNotificationType()==Type.PHONE){
                    try{
                        psService.sendSMS(notification);
                        notification.setStatusValue(Status.SENT);
                        nsService.saveNotify(notification);

                    } catch(Exception e){
                        e.getStackTrace();
                        notification.setStatusValue(Status.ERRORS);
                        nsService.saveNotify(notification);
                    }
                }

                else if(notification.getNotificationType()==Type.TELEGRAM){
                    try{
                        tsService.sendTelegram(notification);
                        notification.setStatusValue(Status.SENT);
                        nsService.saveNotify(notification);

                    } catch(Exception e){
                        e.getStackTrace();
                        notification.setStatusValue(Status.ERRORS);
                        nsService.saveNotify(notification);
                    }
                }
                else{
                            notification.setStatusValue(Status.ERRORS);
                            System.out.println("Данный тип отправки не предусмотрен");
                }
            }
    }
}