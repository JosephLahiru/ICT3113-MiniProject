package me.mtron.user;

import java.time.LocalDateTime;

public class Message {
    private String senderName;
    private String messageContent;
    private LocalDateTime timestamp;

    public Message(String senderName, String messageContent) {
        this.senderName = senderName;
        this.messageContent = messageContent;
        this.timestamp = LocalDateTime.now();
    }

    public String getSenderName() {
        return senderName;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}