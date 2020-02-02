package com.codding.edemail.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transfers")
public class smsstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="transfer_id")
    private Long transferId;

    @Column(name="rs_id")
    private Long rsId;

    @Column(name="status_id")
    private Long statusId;

    @Column(name="notification_id")
    private Long notificationId;

    @Column(name="recipient")
    private String recipient;

    @Column(name="sent_date")
    private Date sentDate;

    @Column(name="sent_status_update")
    private Date sentStatusUpdate;

  /*public smsstatus(){}
    public smsstatus(Long transferId, Long notificationId, String recipient, String message){
        this.transferId=transferId;
        this.notificationId=notificationId;
        this.recipient=recipient;
    }*/

    public Long getTransferId() {
        return transferId;
    }

    public void setTransferId(Long transferId) {
        this.transferId = transferId;
    }

    public Long getRsId() {
        return rsId;
    }

    public void setRsId(Long rsId) {
        this.rsId = rsId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getSentStatusUpdate() {
        return sentStatusUpdate;
    }

    public void setSentStatusUpdate(Date sentStatusUpdate) {
        this.sentStatusUpdate = sentStatusUpdate;
    }
}