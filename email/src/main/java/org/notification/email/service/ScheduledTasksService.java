package org.notification.email.service;

import org.notification.email.entity.Notifications;
import org.notification.email.entity.Status;
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

    @Autowired
    public ScheduledTasksService( NotificationsRepository notificationsRepository, MailSenderService msService) {
        this.notificationsRepository = notificationsRepository;
        this.msService = msService;
    }

        @Async
        @Scheduled(cron="0 0/5 * 1/1 * *")//(fixedRate = 30000)
        public void sentNotifications(){
            List<Notifications> nList = notificationsRepository.findByStatus("Wait");

            for(Notifications notifications: nList) {
                msService.sendEmail(notifications);
                notificationsRepository.setValue("Sent");
            }
    }
}