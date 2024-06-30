package com.example.auction_system.exceptions;

public class UsernameExistsException extends AuctionSystemBaseException {
    public UsernameExistsException(String message) {
        super(message);
    }
}
