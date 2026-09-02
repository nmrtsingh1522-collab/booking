package com.java.booking.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TouristRequest(

        @NotBlank(message = "Name is required")
        String touristName,
        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email")
        String email,
        @NotBlank(message = "Phone number is required")
        @Pattern(
                regexp = "^[0=9]{10}$",
                message = "Phone number contains 10 digits"
        )
        String phone,
        @NotBlank(message = "City id required")
        String city
) {
}
