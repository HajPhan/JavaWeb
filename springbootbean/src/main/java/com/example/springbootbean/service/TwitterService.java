package com.example.springbootbean.service;

public class TwitterService implements MessageService {

    @Override
    public boolean sendMessage(String msg, String rec) {
        System.err.println("Twitter message sent to " +  rec + " with message = " + msg);
        return true;
    }
}
