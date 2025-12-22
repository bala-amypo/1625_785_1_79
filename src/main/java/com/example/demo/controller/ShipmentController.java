package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.service.RouteOptimizationService;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController

public class ShipmentController {

    private final ShipmentService shipmentService;
    private final RouteOptimizationService routeService;

    public ShipmentController(ShipmentService ss, RouteOptimizationService rs) {
        this.shipmentService = ss;
        this.routeService = rs;
    }

    @PostMapping("/shipments/{vehicleId}")
    public ShipmentEntity createShipment(@PathVariable Long vehicleId,
                                         @RequestBody ShipmentEntity shipment) {
        return shipmentService.createShipment(vehicleId, shipment);
    }

    @PostMapping("/{shipmentId}/optimize")
    public RouteOptimizationEntity optimize(@PathVariable Long shipmentId) {
        return routeService.optimizeRoute(shipmentId);
    }
}
