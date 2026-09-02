package com.java.booking.model;

import java.time.LocalDate;

public record BookingResponse(
        Long id,
        Long touristId,
        String touristName,
        String touristEmail,
        String Destination,
        LocalDate bookingDate,
        Integer numberOfPeople,
        String status
) {
}
