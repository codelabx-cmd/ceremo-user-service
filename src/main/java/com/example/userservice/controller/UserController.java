package com.example.userservice.controller;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public User register(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);

    }
}
