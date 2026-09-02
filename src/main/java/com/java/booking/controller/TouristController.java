package com.java.booking.controller;

import com.java.booking.entity.Tourist;
import com.java.booking.model.TouristRequest;
import com.java.booking.model.TouristResponse;
import com.java.booking.service.TouristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    private TouristService touristService;


    @PostMapping
    public ResponseEntity<TouristResponse> registerTourist(@Valid @RequestBody TouristRequest tourist) {
        return ResponseEntity.ok(
                touristService.registerTourist(tourist)
        );
    }

    @GetMapping
    public ResponseEntity<List<TouristResponse>> getAllTourist() {
        return  ResponseEntity.ok(
                touristService.getAllTourist()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristResponse> getTouristById(@PathVariable Long id) {
        return ResponseEntity.ok(
                touristService.getTouristById(id)
        );
    }

    @DeleteMapping("/{touristId}")
    public void deleteById(@PathVariable Long touristId) {
        touristService.deleteTourist(touristId);
    }
}
