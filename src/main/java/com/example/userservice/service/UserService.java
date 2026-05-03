package com.example.userservice.service;

import com.example.userservice.dto.UserRequest;
import com.example.userservice.entity.User;
import com.example.userservice.exception.GlobalExceptionHandler;
import com.example.userservice.exception.UserAlreadyExistsException;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User registerUser(UserRequest request) {
        userRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new UserAlreadyExistsException("Email already registered");});

        User user = User.builder().name(request.getName()).email(request.getEmail())
                .password(request.getPassword()) // later we hash
                .phone(request.getPhone())
                .role(User.Role.valueOf(request.getRole().toUpperCase()))
                .build();
        return  userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
