package com.example.demo.service.impl;

import com.example.demo.entity.LocationEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.entity.VehicleEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.ShipmentService;

import java.time.LocalDate;

public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    public ShipmentServiceImpl(ShipmentRepository sr, VehicleRepository vr, LocationRepository lr) {
        this.shipmentRepository = sr;
        this.vehicleRepository = vr;
        this.locationRepository = lr;
    }

    @Override
    public ShipmentEntity createShipment(Long vehicleId, ShipmentEntity shipment) {

        if (shipment.getScheduledDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Scheduled date is in the past");
        }

        VehicleEntity vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (shipment.getWeightKg() > vehicle.getCapacityKg()) {
            throw new IllegalArgumentException("Weight exceeds vehicle capacity");
        }

        LocationEntity pickup = locationRepository.findById(
                shipment.getPickupLocation().getId()).orElseThrow();
        LocationEntity drop = locationRepository.findById(
                shipment.getDropLocation().getId()).orElseThrow();

        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(pickup);
        shipment.setDropLocation(drop);

        return shipmentRepository.save(shipment);
    }

    @Override
    public ShipmentEntity getShipment(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
