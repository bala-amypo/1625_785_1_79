package com.example.demo.controller;

import com.example.demo.entity.LocationEntity;
import com.example.demo.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService ls) {
        this.locationService = ls;
    }

    @PostMapping
    public LocationEntity createLocation(@RequestBody LocationEntity location) {
        return locationService.createLocation(location);
    }

    @GetMapping
    public List<LocationEntity> getAllLocations() {
        return locationService.getAllLocations();
    }
}
