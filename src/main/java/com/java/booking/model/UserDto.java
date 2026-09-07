package com.java.booking.model;

import lombok.Builder;

@Builder
public record UserDto (
        Long id,
        String firstName,
        String lastName,
        String email
) {}