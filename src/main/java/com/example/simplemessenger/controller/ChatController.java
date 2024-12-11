package com.example.simplemessenger.controller;

import com.example.simplemessenger.model.ChatDTO;
import com.example.simplemessenger.model.UserChat;
import com.example.simplemessenger.service.ChatService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChatDTO>> getUserChats(@PathVariable Long userId) {
        List<ChatDTO> userChats = chatService.getChatsForUser(userId);
        return ResponseEntity.ok(userChats);
    }

}
