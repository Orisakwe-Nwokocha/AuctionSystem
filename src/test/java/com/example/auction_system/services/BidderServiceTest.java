package com.example.auction_system.services;

import com.example.auction_system.dtos.requests.RegisterRequest;
import com.example.auction_system.dtos.responses.ApiResponse;
import com.example.auction_system.dtos.responses.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.auction_system.utils.TestUtils.buildRegisterRequest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BidderServiceTest {
    
    @Autowired
    private BidderService bidderService;

    @Test
    void registerBidderTest() {
        RegisterRequest request = buildRegisterRequest();
        ApiResponse<RegisterResponse> response = bidderService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.isSuccessful()).isTrue();
        assertThat(response.getMessage()).contains("success");
        String role = response.getData().getBioData().getRole();
        assertThat(role).isEqualTo("BIDDER");
    }

}