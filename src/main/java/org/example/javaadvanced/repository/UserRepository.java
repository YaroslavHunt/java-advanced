package org.example.javaadvanced.repository;

import org.example.javaadvanced.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    void deleteByEmail(String email);
}
