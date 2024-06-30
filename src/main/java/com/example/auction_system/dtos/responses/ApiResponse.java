package com.example.auction_system.dtos.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private LocalDateTime requestTime;
    private boolean isSuccessful;
    private String message;
    private T data;
}
