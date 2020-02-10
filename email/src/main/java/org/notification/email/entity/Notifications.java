package org.notification.email.entity;

/**
 * @task Создать программу для отправки уведомления
 * @aim Демонстрация Умения работать с jpa, database and ect
 * @version 1.0 __.__.2020
 * @author Akhmedkhodzhaev A.A.
 * @others так же возмоно разработать тест, для проверки работы программы
 */


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name="notifications")
public class Notifications {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="ns_id")
    private Long nsId;

    @Column(name="notification_type")
    private String notificationType;

    @Column(name="recipient")
    private String recipient;

    @Column(name="message")
    private String message;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status statusValue;

    @CreationTimestamp
    @Column(name="send_date")
    private LocalDateTime sendDate;

    @UpdateTimestamp
    @Column(name="lastupdate")
    private LocalDateTime lastUpdate;


}