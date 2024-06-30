package com.example.auction_system.data.repositories;

import com.example.auction_system.data.models.BioData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BioDataRepository extends JpaRepository<BioData, Long> {
    boolean existsByUsername(String username);
}
