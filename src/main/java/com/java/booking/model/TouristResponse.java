package com.java.booking.model;

public record TouristResponse(
        Long id,
        String name,
        String email,
        String phone,
        String city
) {
}