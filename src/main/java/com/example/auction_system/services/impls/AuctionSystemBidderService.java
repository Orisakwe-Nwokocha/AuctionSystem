package com.example.auction_system.services.impls;

import com.example.auction_system.data.models.Bidder;
import com.example.auction_system.data.models.BioData;
import com.example.auction_system.data.repositories.BidderRepository;
import com.example.auction_system.dtos.requests.RegisterRequest;
import com.example.auction_system.dtos.responses.ApiResponse;
import com.example.auction_system.dtos.responses.RegisterResponse;
import com.example.auction_system.services.BioDataService;
import com.example.auction_system.services.BidderService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.time.LocalDateTime.now;

@Service
@Slf4j
public class AuctionSystemBidderService implements BidderService {

    private final BidderRepository bidderRepository;
    private final BioDataService bioDataService;

    private final ModelMapper mapper;

    @Autowired
    public AuctionSystemBidderService(BidderRepository bidderRepository,
                                      BioDataService bioDataService, ModelMapper mapper) {
        this.bidderRepository = bidderRepository;
        this.bioDataService = bioDataService;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public ApiResponse<RegisterResponse> register(RegisterRequest request) {
        log.info("Trying to register new bidder");
        Bidder newBidder = mapper.map(request, Bidder.class);
        BioData bioData = bioDataService.saveBioData(request);
        newBidder.setBioData(bioData);
        newBidder = bidderRepository.save(newBidder);
        RegisterResponse response = mapper.map(newBidder, RegisterResponse.class);
        String message = "User registered successfully";
        log.info("Bidder registered successfully");
        return buildApiResponse(response, message);
    }

    private static <T> ApiResponse<T> buildApiResponse(T data, String message) {
        return ApiResponse.<T>builder()
                .requestTime(now())
                .isSuccessful(true)
                .message(message)
                .data(data)
                .build();
    }
}
