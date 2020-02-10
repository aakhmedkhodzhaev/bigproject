package org.notification.email.repository;

import org.notification.email.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

    @Query(value = "SELECT * FROM notifications WHERE status = :statusValue", nativeQuery = true)
    List<Notifications> findByStatus(@Param("statusValue") String statusValue);

}