package org.notification.email.repository;

import org.notification.email.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

}