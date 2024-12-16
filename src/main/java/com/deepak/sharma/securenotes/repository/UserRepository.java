package com.deepak.sharma.securenotes.repository;

import com.deepak.sharma.securenotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
