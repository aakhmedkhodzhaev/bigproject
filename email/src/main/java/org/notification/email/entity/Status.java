package org.notification.email.entity;

public enum Status {
    WAIT("Wait"),
    SENT("Sent"),
    ERRORS("Errors");

    final String message;

    Status(String message){
        this.message=message;
    }
}