package com.java.booking.Exception;

public class TouristNotFoundException extends RuntimeException {

    public TouristNotFoundException(Long id) {
        super("Tourist not found with id: " + id);
    }
}
