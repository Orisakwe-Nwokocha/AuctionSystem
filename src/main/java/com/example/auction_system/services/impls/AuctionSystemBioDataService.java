package com.example.auction_system.services.impls;

import com.example.auction_system.data.models.BioData;
import com.example.auction_system.data.repositories.BioDataRepository;
import com.example.auction_system.dtos.requests.RegisterRequest;
import com.example.auction_system.exceptions.UsernameExistsException;
import com.example.auction_system.services.BioDataService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuctionSystemBioDataService implements BioDataService {

    private final BioDataRepository bioDataRepository;

    private final ModelMapper mapper;

    @Autowired
    public AuctionSystemBioDataService(BioDataRepository bioDataRepository, ModelMapper mapper) {
        this.bioDataRepository = bioDataRepository;
        this.mapper = mapper;
    }

    @Override
    public BioData saveBioData(RegisterRequest request) {
        String username = request.getUsername().toLowerCase();
        request.setUsername(username);
        log.info("Trying to save bio data for: {}", request.getRole());
        validate(username);
        BioData bioData = mapper.map(request, BioData.class);
        bioData = bioDataRepository.save(bioData);
        log.info("Bio data saved for: {}", request.getRole());
        return bioData;
    }

    private void validate(String username) {
        boolean usernameExists = bioDataRepository.existsByUsername(username);
        if (usernameExists) {
            log.error("Username '{}' is already taken", username);
            throw new UsernameExistsException("Username is already taken");
        }
    }

}
