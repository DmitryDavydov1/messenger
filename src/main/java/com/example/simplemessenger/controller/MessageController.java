package com.example.simplemessenger.controller;

import com.example.simplemessenger.model.Message;
import com.example.simplemessenger.model.User;
import com.example.simplemessenger.model.UserChat;
import com.example.simplemessenger.service.MessageService;
import com.example.simplemessenger.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/message")
@OpenAPIDefinition
public class MessageController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    @PostMapping("/send-message")
    public void sendMessage(Long chatId, Long senderId, String content) {
        messageService.sendMessage(chatId, senderId, content);

    }

    @GetMapping("/get-message")
    public ArrayList<Message> getMessage(Long chatId) {
        return messageService.getMessage(chatId);
    }
}
