package com.example.auction_system.services;

import com.example.auction_system.data.models.BioData;
import com.example.auction_system.dtos.requests.RegisterRequest;

public interface BioDataService {
    BioData saveBioData(RegisterRequest request);
}
