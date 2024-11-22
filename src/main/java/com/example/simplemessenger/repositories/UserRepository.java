package com.example.simplemessenger.repositories;

import com.example.simplemessenger.model.Chat;
import com.example.simplemessenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findById(int userId);
//    @Query("SELECT uc.chat.id FROM UserChat uc WHERE uc.user.id IN (:userIds) GROUP BY uc.chat.id HAVING COUNT(uc.chat.id) = :size")
//    boolean existsByChatIdAndUserId(Chat chat_id, User sender_id);
}
