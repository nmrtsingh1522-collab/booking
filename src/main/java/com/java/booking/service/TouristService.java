package com.java.booking.service;

import com.java.booking.entity.Tourist;
import com.java.booking.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    public Tourist registerTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    public List<Tourist> getAllTourist() {
        return touristRepository.findAll();
    }

    public void deleteTourist(Long touristId) {
        touristRepository.deleteById(touristId);
    }
}
