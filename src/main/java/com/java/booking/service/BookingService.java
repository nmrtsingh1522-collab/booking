package com.java.booking.service;

import com.java.booking.entity.Booking;
import com.java.booking.model.BookingUserDto;
import com.java.booking.model.UserDto;
import com.java.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public BookingUserDto getBookingById(Long bookingId) {
        Booking bookingObject = bookingRepository.findById(bookingId).get();
        UserDto userDetails =  getUser(1L);
        return BookingUserDto
                .builder()
                .bookingDetails(bookingObject)
                .userDetail(userDetails)
                .build();

    }

    public UserDto getUser(Long userId) {
        String url = "https://dummyjson.com/users/" + userId;
        return restTemplate.getForObject(url, UserDto.class);
    }
}