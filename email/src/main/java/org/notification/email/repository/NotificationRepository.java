package org.notification.email.repository;

import java.util.List;

import org.notification.email.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query(value = "SELECT * FROM notifications WHERE status = :statusValue", nativeQuery = true)
    List<Notification> findByStatus(@Param("statusValue") String statusValue);

}