package org.notification.email.service;

import org.notification.email.entity.Notifications;
import org.notification.email.repository.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NotificationsService {

    private final NotificationsRepository notificationsRepository;

    @Autowired
    public NotificationsService(NotificationsRepository notificationsRepository){
        this.notificationsRepository=notificationsRepository;
    }

    public List<Notifications> findAll(){
        return notificationsRepository.findAll();
    }
}