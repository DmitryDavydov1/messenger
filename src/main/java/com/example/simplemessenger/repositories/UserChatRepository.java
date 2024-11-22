package com.example.simplemessenger.repositories;

import com.example.simplemessenger.model.Chat;
import com.example.simplemessenger.model.User;
import com.example.simplemessenger.model.UserChat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserChatRepository extends JpaRepository<UserChat, Long> {
    boolean existsByUserAndChat(User user, Chat chat);
    List<UserChat> findByUser(User user);
}
