package com.java.booking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    private LocalDate bookingDate;
    private String destinationName;
    private int duration;
    private double packagePrice;

    @ManyToOne
    @JoinColumn(name = "tourist_id")
    @JsonBackReference
    private Tourist tourist;
}
