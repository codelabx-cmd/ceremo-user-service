package com.example.userservice.dto;

import java.time.LocalDateTime;

public record LoginResponse (
    Long userId,
    String name,
    String email,
    String role,
    String token,
    LocalDateTime loginTime
) {
}
