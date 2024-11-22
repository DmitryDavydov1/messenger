package com.example.simplemessenger.service;

import com.example.simplemessenger.model.Message;
import com.example.simplemessenger.repositories.ChatRepository;
import com.example.simplemessenger.repositories.MessageRepository;
import com.example.simplemessenger.repositories.UserChatRepository;
import com.example.simplemessenger.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserChatRepository userChatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;


    private final UserService userService;
    private final ChatService chatService;

    public MessageService(UserService userService, ChatService chatService) {
        this.userService = userService;
        this.chatService = chatService;
    }

    public void sendMessage(Long chatId, Long senderId, String content) {
        // Проверяем, что пользователь участвует в чате
        boolean isParticipant = userChatRepository.existsByChatIdAndUserId(chatId, senderId);
        if (!isParticipant) {
            throw new IllegalArgumentException("Пользователь не участвует в этом чате.");
        }

        // Создаем объект сообщения
        Message message = new Message();
        message.setChat(chatService.getChatByEmail(chatId)); // Устанавливаем чат
        message.setSender(userService.getUserByEmail(senderId)); // Устанавливаем отправителя
        message.setContent(content); // Устанавливаем текст сообщения
        message.setTimestamp(LocalDateTime.now()); // Устанавливаем текущее время
        message.setStatus("sent"); // Устанавливаем статус по умолчанию

        // Сохраняем сообщение в базе данных
        messageRepository.save(message);
    }
}
