package com.mobpro.hslu.itengebs.helloeve.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by gebs on 5/15/17.
 */

public class Message extends SugarRecord<Message> {
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
