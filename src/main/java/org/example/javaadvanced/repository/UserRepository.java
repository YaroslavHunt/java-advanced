package org.example.javaadvanced.repository;

import org.example.javaadvanced.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    void deleteByEmail(String email);
    User findUserByEmail(String email);
}
