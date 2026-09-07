package com.java.booking.service;

import com.java.booking.model.UserDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(
            name = "userService",
            fallbackMethod = "getUserFallback"
    )
    public UserDto getUser(Long userId) {

        String url = "http://localhost:9999/users/" + userId;

        return restTemplate.getForObject(
                url,
                UserDto.class
        );
    }

    public UserDto getUserFallback(
            Long userId,
            Throwable throwable) {

        System.out.println(
                "User service is unavailable: "
                        + throwable.getMessage()
        );

        return UserDto.builder()
                .id(userId)
                .firstName("Unknown")
                .lastName("User")
                .build();
    }
}