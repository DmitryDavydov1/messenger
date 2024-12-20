package com.example.simplemessenger.controller;

import com.example.simplemessenger.model.Message;
import com.example.simplemessenger.model.MessageDto;
import com.example.simplemessenger.model.User;
import com.example.simplemessenger.model.UserChat;
import com.example.simplemessenger.service.MessageService;
import com.example.simplemessenger.service.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/message")
@OpenAPIDefinition
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    @PostMapping("/send-message")
    public void sendMessage(@RequestBody MessageDto message) {
        messageService.sendMessage(message.getId(), message.getSender(), message.getContent());

    }

    @GetMapping("/get-message/{chatId}")
    public ArrayList<Message> getMessage(@PathVariable Long chatId) {
        return messageService.getMessage(chatId);
    }
}
