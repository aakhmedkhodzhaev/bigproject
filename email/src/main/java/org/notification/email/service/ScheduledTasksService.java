package org.notification.email.service;

import org.notification.email.entity.Notifications;
import org.notification.email.entity.Status;
import org.notification.email.entity.Type;
import org.notification.email.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ScheduledTasks")
public class ScheduledTasksService {

        private final NotificationsRepository notificationsRepository;
        private final MailSenderService msService;
        private final PhoneSenderService psService;
        private final TelegramSenderService tsService;

    @Autowired
    public ScheduledTasksService(NotificationsRepository notificationsRepository, MailSenderService msService, PhoneSenderService psService, TelegramSenderService tsService) {
        this.notificationsRepository = notificationsRepository;
        this.msService = msService;
        this.psService = psService;
        this.tsService = tsService;
    }

        @Async
        @Scheduled(cron="0 0/5 * 1/1 * *")
        public void sentNotifications(){

            List<Notifications> nList = notificationsRepository.findByStatus(Status.WAIT.name());

            for(Notifications notifications: nList) {
                if(notifications.getNotificationType()==Type.EMAIL){
                    try{
                        msService.sendEmail(notifications);
                        notifications.setStatusValue(Status.SENT);
                        notificationsRepository.save(notifications);

                    } catch(Exception e){
                        e.getStackTrace();
                        notifications.setStatusValue(Status.ERRORS);
                        notificationsRepository.save(notifications);
                    }
                }
                else if(notifications.getNotificationType()==Type.PHONE){
                    try{
                        psService.sendSMS(notifications);
                        notifications.setStatusValue(Status.SENT);
                        notificationsRepository.save(notifications);

                    } catch(Exception e){
                        e.getStackTrace();
                        notifications.setStatusValue(Status.ERRORS);
                        notificationsRepository.save(notifications);
                    }
                }

                else if(notifications.getNotificationType()==Type.TELEGRAM){
                    try{
                        tsService.sendTelegram(notifications);
                        notifications.setStatusValue(Status.SENT);
                        notificationsRepository.save(notifications);

                    } catch(Exception e){
                        e.getStackTrace();
                        notifications.setStatusValue(Status.ERRORS);
                        notificationsRepository.save(notifications);
                    }
                }
                else{
                            notifications.setStatusValue(Status.ERRORS);
                            System.out.println("Данный тип отправки не предусмотрен");
                }
            }
    }
}