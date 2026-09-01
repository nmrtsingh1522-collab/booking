package com.java.booking.model;

import com.java.booking.entity.Booking;
import lombok.Builder;

@Builder
public record BookingUserDto (
        UserDto userDetail,
     Booking bookingDetails
) {}
