package com.example.auction_system.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    @JsonProperty(value = "user_id")
    private Long id;
    private BioDataResponse bioData;
}
