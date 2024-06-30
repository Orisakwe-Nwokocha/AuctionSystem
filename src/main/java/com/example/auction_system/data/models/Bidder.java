package com.example.auction_system.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "bidders")
@Getter
@Setter
public class Bidder {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "bio_data_id")
    private BioData bioData;

}
