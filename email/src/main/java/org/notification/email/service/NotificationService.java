package org.notification.email.service;

import org.notification.email.entity.Notification;
import org.notification.email.entity.Status;
import org.notification.email.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> findAll(){
        return notificationRepository.findAll();
    }

    public void saveNotify(Notification notification){
        notificationRepository.save(notification);
    }


    public List<Notification> findByStatus(){
        return notificationRepository.findByStatus(Status.WAIT.name());
    }

}