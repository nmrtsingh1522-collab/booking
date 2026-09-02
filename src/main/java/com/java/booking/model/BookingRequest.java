package com.java.booking.model;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookingRequest(
        @NotNull(message = "Tourist ID is required")
        Long touristId,
        @NotNull(message = "Destination is required")
        String destination,
        @NotNull(message = "Booking date is required")
        @Future(message = "Booking date must be in future")
        LocalDate bookingDate,
        @NotNull(message = "Number od people is required")
        @Min(value = 1, message = "At least one person is required")
        Integer numberOfPeople
) {
}
