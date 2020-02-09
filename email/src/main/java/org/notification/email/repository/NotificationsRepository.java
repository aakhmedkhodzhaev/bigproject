package org.notification.email.repository;

import org.notification.email.entity.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NotificationsRepository extends JpaRepository<Notifications, Long> {

    @Query(value = "SELECT * FROM notifications WHERE status = :statusValue", nativeQuery = true)
    List<Notifications> findByStatus(@Param("statusValue") String statusValue);
/*
    @Query(value = "UPDATE notifications SET status=:statusValue WHERE ns_id in (select s.ns_id from notifications s where s.status='Wait')", nativeQuery = true)
    @Modifying
    @Transactional
    void setValue(@Param("statusValue") String statusValue);*/

}