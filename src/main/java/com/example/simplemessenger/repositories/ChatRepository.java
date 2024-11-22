package com.example.simplemessenger.repositories;

import com.example.simplemessenger.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
    @Query("SELECT uc.chat.id FROM UserChat uc WHERE uc.user.id IN (:userIds) GROUP BY uc.chat.id HAVING COUNT(uc.chat.id) = :size")
    Optional<Long> findExistingChatBetweenUsers(@Param("userIds") List<Long> userIds, @Param("size") long size);
}
