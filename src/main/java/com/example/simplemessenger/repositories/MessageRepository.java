package com.example.simplemessenger.repositories;

import com.example.simplemessenger.model.Chat;
import com.example.simplemessenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChat(Chat chat);
    Message findTopByChatIdOrderByTimestampDesc(Long chatId);

}
