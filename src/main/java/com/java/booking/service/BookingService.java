package com.java.booking.service;

import com.java.booking.entity.Booking;
import com.java.booking.model.BookingUserDto;
import com.java.booking.model.UserDto;
import com.java.booking.repository.BookingRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;

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
        UserDto userDetails =  userService.getUser(1L);
        return BookingUserDto
                .builder()
                .bookingDetails(bookingObject)
                .userDetail(userDetails)
                .build();

    }

    /*@CircuitBreaker(
            name = "userService",
            fallbackMethod = "getUserFallback"
    )
    public UserDto getUser(Long userId) {
        String url = "http://localhost:9999/users/" + userId;
        return restTemplate.getForObject(url, UserDto.class);
    }

    public UserDto getUserFallback(Long userId, Throwable throwable) {
        System.out.println("User service is Unavailable: "+ throwable.getMessage());

        return UserDto
                .builder()
                .id(userId)
                .firstName("Unknown")
                .lastName("User")
                .build();

    }*/
}