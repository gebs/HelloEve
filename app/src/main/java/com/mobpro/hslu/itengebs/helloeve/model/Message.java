package com.mobpro.hslu.itengebs.helloeve.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by gebs on 5/15/17.
 */

public class Message extends SugarRecord<Message> {
    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    String messageText;
    String receiverPhoneNumber;
    Date timestamp;

    public Message() {
    }

    public Message(String messageText, String receiverPhoneNumber, Date timestamp) {
        this.messageText = messageText;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.timestamp = timestamp;
    }
}
