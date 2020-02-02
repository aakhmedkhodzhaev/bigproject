package org.notification.email.service;

import org.notification.email.entity.Notifications;
import org.notification.email.repository.ScheduledTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("ScheduledTasks")
public class ScheduledTasksService {

        private final ScheduledTaskRepository scheduledTaskRepository;
        private final mailSenderService msService;

    @Autowired
    public ScheduledTasksService(ScheduledTaskRepository scheduledTaskRepository, mailSenderService msService) {
        this.scheduledTaskRepository = scheduledTaskRepository;
        this.msService = msService;
    }

        @Async
        @Scheduled(cron="* 20 * * * *")//(fixedRate = 30000)
        public void sentNotifications(){
            List<Notifications> nList = scheduledTaskRepository.findByStatus("Wait");
            SimpleMailMessage email = new SimpleMailMessage();
      //    for(int i=0; i<nList.size(); i++){
            for(Notifications notifications: nList){
            email.setTo(notifications.getRecipient());
            email.setSubject("email");
            email.setFrom("aakhmedkhodzhaev@gmail.com");
            email.setText(notifications.getMessage());

            msService.sendEmail(email);
//          scheduledTaskRepository.setValue("Sent", notifications.getNsId());
            }

        //    return notificationsRepository.setValue("Sent", notifications.getNsId());
    }
}