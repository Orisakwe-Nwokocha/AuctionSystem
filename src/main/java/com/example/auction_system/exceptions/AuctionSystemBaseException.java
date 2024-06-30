package com.example.auction_system.exceptions;

public  abstract class AuctionSystemBaseException extends RuntimeException {
    public AuctionSystemBaseException(String message) {
        super(message);
    }
}
