package com.example.simplemessenger.controller;

import com.example.simplemessenger.model.Chat;
import com.example.simplemessenger.service.ChatService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
//@Api(tags = "Chat Management")
public class ChatController {

//    @Autowired
//    private ChatService chatService;
//
//    // Другие методы...
//
//    @PostMapping("/create")
//    @ApiOperation(value = "Создать новый чат с пользователями",
//            notes = "Создает чат с указанным именем и списком пользователей по их ID.")
//    public ResponseEntity<Void> createChatWithUsers(
//            @ApiParam(value = "Имя чата", required = true) @RequestParam String chatName,
//            @ApiParam(value = "Список ID пользователей", required = true) @RequestBody List<Long> userIds) {
//        chatService.createChatWithUsers(chatName, userIds);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
}
