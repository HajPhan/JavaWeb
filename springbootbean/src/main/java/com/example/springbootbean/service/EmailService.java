package com.example.springbootbean.service;

public class EmailService implements MessageService {
    @Override
    public boolean sendMessage(String msg, String rec) {
        System.err.println("Email send to " + rec + " with message = " + msg);
        return true;
    }
}
