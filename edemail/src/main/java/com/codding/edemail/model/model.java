package com.codding.edemail.model;

/**
 * @task Создать программу для отправки почты
 * @aim Демонстрация Умения работать с jpa, database and ect
 * @version 1.0 24.01.2020
 * @author Akhmedkhodzhaev A.A.
 * @others так же возмоно разработать тест, для проверки работы программы
 */

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name="registrationsend")
public class model {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="rs_id")
    private Long rsId;

    @Column(name="Notification_Type")
    private String notificationType;

    @Column(name="recipient")
    private String recipient;

    @Column(name="message")
    private String message;
}