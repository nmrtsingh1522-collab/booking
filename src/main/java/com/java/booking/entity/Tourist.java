package com.java.booking.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tourist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long touristId;

    private String fullName;
    private String email;
    private String passportNumber;

    @OneToMany(mappedBy = "tourist")
    @JsonManagedReference
    private List<Booking> bookings;
}
