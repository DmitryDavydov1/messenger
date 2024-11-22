package com.example.simplemessenger.controller;

import com.example.simplemessenger.service.ChatService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chats")
@OpenAPIDefinition
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/get-or-create")
    public ResponseEntity<Long> getOrCreateChat(@RequestParam Long userId1, @RequestParam Long userId2) {
        Long chatId = chatService.getOrCreateChatBetweenUsers(userId1, userId2);
        return ResponseEntity.ok(chatId);
    }
}
