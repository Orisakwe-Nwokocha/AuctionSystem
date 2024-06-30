package com.example.auction_system.data.models;

import com.example.auction_system.data.constants.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;
import static lombok.AccessLevel.NONE;

@Entity
@Table(name = "bio_data")
@Getter
@Setter
public class BioData {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(STRING)
    private Role role;
    @Setter(NONE)
    private LocalDateTime dateRegistered;
    @Setter(NONE)
    private LocalDateTime dateUpdated;

    @OneToOne(mappedBy = "bioData", cascade = ALL)
    private Bidder bidder;

//    @OneToOne(mappedBy = "bioData", cascade = ALL)
//    private Seller seller;

    @PrePersist
    private void setDateRegistered() {
        dateRegistered = now();
    }

    @PreUpdate
    private void setDateUpdated() {
        dateUpdated = now();
    }

}
