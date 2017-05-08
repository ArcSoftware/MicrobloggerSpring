package com.theironyard;

/**
 * Created by Jake on 5/8/17.
 */
public class Message {
    private static int messageCount = 0;
    Integer id;
    String messageText;

    public Message() {
        id = messageCount;
        messageCount++;
    }

    public Message(String messageText) {
        this();
        this.messageText = messageText;
    }

    public static int getMessageCount() {
        return messageCount;
    }

    public Integer getId() {
        return id;
    }

    public String getMessageText() {
        return messageText;
    }
}
