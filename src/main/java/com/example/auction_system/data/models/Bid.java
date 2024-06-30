package com.example.auction_system.data.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;

@Entity
@Table(name = "bids")
@Getter
@Setter
public class Bid {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private Bidder bidder;

    @ManyToOne
    private Auction auction;


    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Setter(AccessLevel.NONE)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime bidTime;

    @PrePersist
    private void setBidTime(){
        bidTime = now();

    }
    
}
