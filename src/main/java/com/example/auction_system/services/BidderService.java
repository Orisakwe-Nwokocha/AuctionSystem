package com.example.auction_system.services;

import com.example.auction_system.dtos.requests.RegisterRequest;
import com.example.auction_system.dtos.responses.ApiResponse;
import com.example.auction_system.dtos.responses.RegisterResponse;

public interface BidderService {
    ApiResponse<RegisterResponse> register(RegisterRequest request);
}
