package org.notification.email.service;

import java.util.List;

import org.notification.email.entity.Notification;
import org.notification.email.entity.Status;
import org.notification.email.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service("ScheduledTasks")
public class ScheduledTasksService {

    private final NotificationService nsService;

    @Autowired
    public ScheduledTasksService(NotificationService nsService) {
        this.nsService = nsService;
    }

    @Autowired
    private List<SenderRepository> srList;

    @Async
    @Scheduled(cron = "0 0/5 * 1/1 * *")
    public void sentNotifications() {
        List<Notification> nList = nsService.findBystatusValue();

        for (Notification notification : nList) {
            for (SenderRepository sList : srList) {
                if (sList.getType() == notification.getNotificationType()) {
                    try {
                        sList.send(notification);
                        notification.setStatusValue(Status.SENT);
                        nsService.saveNotify(notification);

                    } catch (Exception e) {
                        e.getStackTrace();
                        notification.setStatusValue(Status.ERRORS);
                        nsService.saveNotify(notification);
                    }
                }
            }
        }
    }
}