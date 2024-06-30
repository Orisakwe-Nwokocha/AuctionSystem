package com.example.auction_system.dtos.requests;

import com.example.auction_system.data.constants.Role;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.EnumType.STRING;

@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    @Enumerated(STRING)
    private Role role;
}
