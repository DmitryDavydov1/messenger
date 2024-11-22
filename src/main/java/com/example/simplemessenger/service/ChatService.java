package com.example.simplemessenger.service;

import com.example.simplemessenger.model.Chat;
import com.example.simplemessenger.model.User;
import com.example.simplemessenger.model.UserChat;
import com.example.simplemessenger.repositories.ChatRepository;
import com.example.simplemessenger.repositories.UserChatRepository;
import com.example.simplemessenger.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserChatRepository userChatRepository;
    private final UserService userService;

    public ChatService(ChatRepository chatRepository, UserChatRepository userChatRepository, UserService userService) {
        this.chatRepository = chatRepository;
        this.userChatRepository = userChatRepository;
        this.userService = userService;
    }

    public Long getOrCreateChatBetweenUsers(Long userId1, Long userId2) {
        // Упорядочим идентификаторы для предотвращения дубликатов
        List<Long> userIds = List.of(userId1, userId2).stream().sorted().toList();

        // Проверяем существующий чат
        Optional<Long> existingChatId = chatRepository.findExistingChatBetweenUsers(userIds, userIds.size());

        if (existingChatId.isPresent()) {
            return existingChatId.get();
        }

        // Чат не найден, создаём новый
        Chat newChat = new Chat();
        newChat.setCreatedAt(LocalDateTime.now());
        newChat = chatRepository.save(newChat);

        // Создаём записи в UserChat
        UserChat userChat1 = new UserChat();
        userChat1.setUser(userService.getUserByEmail(userIds.get(0))); // Заглушка; лучше использовать объект из UserService
        userChat1.setChat(newChat);
        userChat1.setJoinedAt(LocalDateTime.now());

        UserChat userChat2 = new UserChat();
        userChat2.setUser((userService.getUserByEmail(userIds.get(1)))); // Заглушка; лучше использовать объект из UserService
        userChat2.setChat(newChat);
        userChat2.setJoinedAt(LocalDateTime.now());

        userChatRepository.saveAll(List.of(userChat1, userChat2));

        return newChat.getId();
    }
}
