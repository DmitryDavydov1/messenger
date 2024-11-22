package com.example.simplemessenger.service;

import com.example.simplemessenger.model.*;
import com.example.simplemessenger.repositories.ChatRepository;
import com.example.simplemessenger.repositories.MessageRepository;
import com.example.simplemessenger.repositories.UserChatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserChatRepository userChatRepository;
    private final UserService userService;
    private final MessageRepository messageRepository;

    public ChatService(ChatRepository chatRepository, UserChatRepository userChatRepository, UserService userService, MessageRepository messageRepository) {
        this.chatRepository = chatRepository;
        this.userChatRepository = userChatRepository;
        this.userService = userService;
        this.messageRepository = messageRepository;
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

    public Chat getChatByEmail(Long id) {
        return chatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("chat not found"));
    }

    public  List<UserChat> allChats(Long user_id){
        return userChatRepository.findByChatId(user_id);
    }

    public List<ChatDTO> getChatsForUser(Long userId) {
        // 1. Получить список chatId, где участвует пользователь
        List<Long> chatIds = userChatRepository.findChatIdsByUserId(userId);

        // 2. Создать список DTO
        List<ChatDTO> chatDTOs = new ArrayList<>();
        for (Long chatId : chatIds) {
            // Найти чат по ID
            Chat chat = chatRepository.findById(chatId)
                    .orElseThrow(() -> new RuntimeException("Chat not found with id " + chatId));

            // Получить список участников
            List<User> participants = chat.getParticipants().stream()
                    .map(UserChat::getUser)
                    .collect(Collectors.toList());

            // Получить последнее сообщение чата
            Message lastMessage = messageRepository.findTopByChatIdOrderByTimestampDesc(chatId);

            // Создать DTO
            ChatDTO chatDTO = new ChatDTO(
                    chat.getId(),
                    participants,
                    lastMessage != null ? lastMessage.getContent() : null,
                    lastMessage != null ? lastMessage.getSender().getId() : null
            );

            chatDTOs.add(chatDTO);
        }

        return chatDTOs;
    }
}
