package org.notification.email.repository;

import java.util.List;

import org.notification.email.entity.Notification;
import org.notification.email.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findBystatusValue(Status statusValue);
}