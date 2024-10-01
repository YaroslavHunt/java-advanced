package org.example.javaadvanced.service;

import org.example.javaadvanced.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserByEmail(String email);

    User updateUser(User user);

    void deleteUser(String email);

}
