package com.example.simplemessenger.repository;

import com.example.simplemessenger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}