package com.github.zz.websocket;

public class MessageData {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "message='" + message + '\'' +
                '}';
    }
}
