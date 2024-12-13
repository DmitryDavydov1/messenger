package com.example.simplemessenger.repositories;

import com.example.simplemessenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findById(int userId);

    boolean existsByEmailAndUsername(String email, String username);

    Optional<User> findByEmail(String email);
//    @Query("SELECT uc.chat.id FROM UserChat uc WHERE uc.user.id IN (:userIds) GROUP BY uc.chat.id HAVING COUNT(uc.chat.id) = :size")
//    boolean existsByChatIdAndUserId(Chat chat_id, User sender_id);
}
