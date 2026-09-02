package com.java.booking.service;

import com.java.booking.Exception.TouristNotFoundException;
import com.java.booking.entity.Tourist;
import com.java.booking.model.TouristRequest;
import com.java.booking.model.TouristResponse;
import com.java.booking.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    public TouristResponse registerTourist(TouristRequest touristRequest) {

        Tourist tourist = Tourist.builder()
                .fullName(touristRequest.touristName())
                .email(touristRequest.email())
                .phoneNo(touristRequest.phone())
                .city(touristRequest.city())
                .build();

        Tourist saved = touristRepository.save(tourist);
        return mapToResponse(saved);
    }

    public List<TouristResponse> getAllTourist() {

        return touristRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public void deleteTourist(Long touristId) {
        touristRepository.deleteById(touristId);
    }


    public TouristResponse getTouristById(Long id) {
        Tourist tourist = touristRepository.findById(id)
                .orElseThrow(() ->
                        new TouristNotFoundException(id));

        return mapToResponse(tourist);
    }

    private TouristResponse mapToResponse(Tourist tourist) {

        return  new TouristResponse(
                tourist.getTouristId(),
                tourist.getFullName(),
                tourist.getEmail(),
                tourist.getPhoneNo(),
                tourist.getCity()
        );
    }
}
