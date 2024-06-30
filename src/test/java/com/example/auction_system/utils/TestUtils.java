package com.example.auction_system.utils;

import com.example.auction_system.dtos.requests.RegisterRequest;

import static com.example.auction_system.data.constants.Role.BIDDER;

public class TestUtils {

    public static RegisterRequest buildRegisterRequest() {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("Bidder");
        request.setPassword("password");
        request.setRole(BIDDER);
        return request;
    }
}
