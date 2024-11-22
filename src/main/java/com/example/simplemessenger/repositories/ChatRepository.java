package com.example.simplemessenger.repositories;

import com.example.simplemessenger.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    // Здесь можно добавить дополнительные методы, если нужно
}
