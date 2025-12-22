package com.example.demo.controller;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vs) {
        this.vehicleService = vs;
    }

    @PostMapping("/vehicles/{userId}")
    public VehicleEntity addVehicle(@PathVariable Long userId,
                                    @RequestBody VehicleEntity vehicle) {
        return vehicleService.addVehicle(userId, vehicle);
    }

    @GetMapping("/user/{userId}")
    public List<VehicleEntity> getVehiclesByUser(@PathVariable Long userId) {
        return vehicleService.getVehiclesByUser(userId);
    }

    @GetMapping("/{id}")
    public VehicleEntity getVehicle(@PathVariable Long id) {
        return vehicleService.findById(id);
    }
}
