package com.example.auction_system.dtos.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BioDataResponse {
    private String username;
    private String role;
    @JsonFormat(pattern = "dd-MMM-yyyy 'at' hh:mm a")
    private LocalDateTime dateRegistered;
    @JsonFormat(pattern = "dd-MMM-yyyy 'at' hh:mm a")
    private LocalDateTime dateUpdated;
}
