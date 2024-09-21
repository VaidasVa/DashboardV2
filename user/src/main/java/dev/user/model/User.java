package dev.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID id;
    private String googleId;
    private String email;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime lastLogin;
}
