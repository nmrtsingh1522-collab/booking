package com.java.booking.controller;

import com.java.booking.entity.Tourist;
import com.java.booking.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    private TouristService touristService;


    @PostMapping
    public Tourist registerTourist(@RequestBody Tourist tourist) {
        return touristService.registerTourist(tourist);
    }

    @GetMapping
    public List<Tourist> getAllTourist() {
        return  touristService.getAllTourist();
    }

    @DeleteMapping("/{touristId}")
    public void deleteById(@PathVariable Long touristId) {
        touristService.deleteTourist(touristId);
    }
}
