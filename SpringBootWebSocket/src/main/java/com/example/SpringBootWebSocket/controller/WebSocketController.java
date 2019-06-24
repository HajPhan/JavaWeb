package com.example.SpringBootWebSocket.controller;

import com.example.SpringBootWebSocket.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.err.println(chatMessage.getSender() + " : " + chatMessage.getContent() + " >> " + chatMessage.getType());
        return chatMessage;
    }

    @MessageMapping(value = "/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        System.err.println(">>>>>>>>>>>>>>>>>>>> User >> " + chatMessage.getSender() + " >> logined... >>>>>>>>>>>>>>>>>>");
        return chatMessage;
    }
}
