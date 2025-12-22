package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;

import java.time.LocalDateTime;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentrepository;
    private final RouteOptimizationRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository sr,
                                        RouteOptimizationRepository rr) {
        this.shipmentrepository = sr;
        this.resultRepository = rr;
    }

    @Override
    public RouteOptimizationEntity optimizeRoute(Long shipmentId) {

        ShipmentEntity shipment = shipmentrepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double distance = Math.hypot(
                shipment.getPickupLocation().getLatitude() - shipment.getDropLocation().getLatitude(),
                shipment.getPickupLocation().getLongitude() - shipment.getDropLocation().getLongitude()
        );

        double fuel = distance / shipment.getVehicle().getFuelEfficiency();



        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationEntity getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
