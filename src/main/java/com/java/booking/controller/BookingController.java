package com.java.booking.controller;

import com.java.booking.entity.Booking;
import com.java.booking.model.BookingUserDto;
import com.java.booking.model.UserDto;
import com.java.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public BookingUserDto getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    /*@GetMapping("/user/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return bookingService.getUser(userId);
    }*/
}
