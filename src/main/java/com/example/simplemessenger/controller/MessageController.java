package com.example.simplemessenger.controller;

import com.example.simplemessenger.model.User;
import com.example.simplemessenger.model.UserChat;
import com.example.simplemessenger.service.MessageService;
import com.example.simplemessenger.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/message")
@OpenAPIDefinition
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/send-message")
    public void sendMessage(Long chatId, Long senderId, String content) {
        messageService.sendMessage(chatId, senderId, content);

    }
}
