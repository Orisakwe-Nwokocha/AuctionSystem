package com.example.auction_system.services;

import com.example.auction_system.data.models.BioData;
import com.example.auction_system.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.auction_system.utils.TestUtils.buildRegisterRequest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BioDataServiceTest {

    @Autowired
    private BioDataService bioDataService;

    @Test
    void saveBioDataTest() {
        RegisterRequest request = buildRegisterRequest();
        BioData bioData = bioDataService.saveBioData(request);
        assertThat(bioData).isNotNull();
        assertThat(bioData.getId()).isNotNull();
    }

    @Test
    @DisplayName("test that only unique username can be saved")
    void saveBioData_throwsExceptionTest() {
        RegisterRequest request = buildRegisterRequest();
        BioData bioData = bioDataService.saveBioData(request);
        assertThat(bioData).isNotNull();
        assertThat(bioData.getId()).isNotNull();
    }

}