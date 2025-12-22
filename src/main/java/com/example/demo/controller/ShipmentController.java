package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.service.RouteOptimizationService;
import com.example.demo.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final RouteOptimizationService routeService;

    public ShipmentController(ShipmentService ss, RouteOptimizationService rs) {
        this.shipmentService = ss;
        this.routeService = rs;
    }

    @PostMapping("/{vehicleId}")
    public ShipmentEntity createShipment(@PathVariable Long vehicleId,
                                         @RequestBody ShipmentEntity shipment) {
        return shipmentService.createShipment(vehicleId, shipment);
    }

    @PostMapping("/{shipmentId}/optimize")
    public RouteOptimizationResultEntity optimize(@PathVariable Long shipmentId) {
        return routeService.optimizeRoute(shipmentId);
    }
}
