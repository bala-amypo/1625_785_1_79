package com.example.demo.service.impl;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.VehicleEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleServiceImpl(VehicleRepository vr, UserRepository ur) {
        this.vehicleRepository = vr;
        this.userRepository = ur;
    }

    @Override
    public VehicleEntity addVehicle(Long userId, VehicleEntity vehicle) {
        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        vehicle.setUser(user);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleEntity> getVehiclesByUser(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }

    @Override
    public VehicleEntity findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
    }
}
