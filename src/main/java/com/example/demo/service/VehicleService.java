package com.example.demo.service;

import com.example.demo.entity.VehicleEntity;

import java.util.List;

public interface VehicleService {
    VehicleEntity addVehicle(Long userId, VehicleEntity vehicle);
    List<VehicleEntity> getVehiclesByUser(Long userId);
    VehicleEntity findById(Long id);
}
