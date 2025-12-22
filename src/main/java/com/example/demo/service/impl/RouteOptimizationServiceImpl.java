package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.routeOptimizationRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;

import java.time.LocalDateTime;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentrepository;
    private final routeoptimizationRepository resultRepository;

    public RouteOptimizationServiceImpl(shipmentrepository sr,
                                        routeoptimizationrepository rr) {
        this.shipmentRepository = sr;
        this.resultRepository = rr;
    }

    @Override
    public RouteOptimizationResultEntity optimizeRoute(Long shipmentId) {

        ShipmentEntity shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double distance = Math.hypot(
                shipment.getPickupLocation().getLatitude() - shipment.getDropLocation().getLatitude(),
                shipment.getPickupLocation().getLongitude() - shipment.getDropLocation().getLongitude()
        );

        double fuel = distance / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResultEntity result =
                RouteOptimizationResultEntity.builder()
                        .shipment(shipment)
                        .optimizedDistanceKm(distance)
                        .estimatedFuelUsageL(fuel)
                        .generatedAt(LocalDateTime.now())
                        .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResultEntity getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
