package com.example.demo.service.impl;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.locationrepository;
import com.example.demo.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {

    private final locationrepository locationRepository;

    public LocationServiceImpl(locationrepository repo) {
        this.locationrepository = repo;
    }

    @Override
    public LocationEntity createLocation(LocationEntity location) {
        if (location.getLatitude() < -90 || location.getLatitude() > 90) {
            throw new IllegalArgumentException("Invalid latitude");
        }
        if (location.getLongitude() < -180 || location.getLongitude() > 180) {
            throw new IllegalArgumentException("Invalid longitude");
        }
        return locationRepository.save(location);
    }

    @Override
    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }
}
