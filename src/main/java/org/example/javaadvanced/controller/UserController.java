package org.example.javaadvanced.controller;

import lombok.AllArgsConstructor;
import org.example.javaadvanced.model.User;
import org.example.javaadvanced.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("save_user")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User successfully saved";
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("update_user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete_user/{email}")
    public String deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return "User successfully deleted";
    }
}
