package com.example.auction_system.data.repositories;

import com.example.auction_system.data.models.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidderRepository extends JpaRepository<Bidder, Long> {
}
