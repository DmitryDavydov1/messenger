package com.example.simplemessenger.repositories;

import com.example.simplemessenger.model.Chat;
import com.example.simplemessenger.model.User;
import com.example.simplemessenger.model.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserChatRepository extends JpaRepository<UserChat, Long> {
    boolean existsByUserAndChat(User user, Chat chat);
    List<UserChat> findByUser(User user);
    List<UserChat> findByChatId(Long id);
    boolean existsByChatIdAndUserId(Long chatId, Long userId);
    @Query("SELECT uc.chat.id FROM UserChat uc WHERE uc.user.id = :userId")
    List<Long> findChatIdsByUserId(@Param("userId") Long userId);
}
