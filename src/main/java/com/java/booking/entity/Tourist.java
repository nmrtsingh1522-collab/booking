package com.java.booking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tourist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long touristId;

    private String fullName;
    private String email;
    private String passportNumber;
    private String phoneNo;
    private String city;

    @OneToMany(mappedBy = "tourist")
    @JsonManagedReference
    private List<Booking> bookings;
}
