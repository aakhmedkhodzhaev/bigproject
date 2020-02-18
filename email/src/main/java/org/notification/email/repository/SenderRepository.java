package org.notification.email.repository;

import org.notification.email.entity.Notification;
import org.notification.email.entity.Type;

public interface SenderRepository {

    void send(Notification notification);

    Type getType();
}