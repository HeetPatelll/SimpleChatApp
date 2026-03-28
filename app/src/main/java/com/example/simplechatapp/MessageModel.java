package com.example.simplechatapp;

public class MessageModel {

    String message;
    boolean isSender;

    public MessageModel(String message, boolean isSender) {
        this.message = message;
        this.isSender = isSender;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSender() {
        return isSender;
    }
}