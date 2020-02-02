package org.notification.email.tasks;

import org.notification.email.entity.Notifications;
import org.notification.email.repository.NotificationsRepository;
import org.notification.email.service.mailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;


@EnableScheduling
public class ScheduledTasks {

        private final NotificationsRepository notificationsRepository;
        private final mailSenderService msService;
        private final Notifications notifications;

    @Autowired
    public ScheduledTasks(NotificationsRepository notificationsRepository, mailSenderService msService, Notifications notifications) {
        this.notificationsRepository = notificationsRepository;
        this.msService = msService;
        this.notifications = notifications;
    }

        @Scheduled(cron="* /20 * * * * *")//(fixedRate = 30000)
        public void sentNotifications(){
            List<Notifications> nList = notificationsRepository.findByStatus("Wait");
            SimpleMailMessage email = new SimpleMailMessage();
      //    for(int i=0; i<nList.size(); i++){
            for(Notifications notifications: nList){
            email.setTo(notifications.getRecipient());
            email.setSubject("email");
            email.setFrom("aakhmedkhodzhaev@gmail.com");
            email.setText(notifications.getMessage());

            msService.sendEmail(email);
            }
        //    return notificationsRepository.setValue("Sent", notifications.getNsId());
    }
}
