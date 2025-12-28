package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.entity.Shipment;
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
    public Shipment createShipment(@PathVariable Long vehicleId,
                                   @RequestBody Shipment shipment) {
        return shipmentService.createShipment(vehicleId, shipment);
    }

    @GetMapping("/{shipmentId}/optimize")
    public RouteOptimizationResult optimize(@PathVariable Long shipmentId) {
        return routeService.optimizeRoute(shipmentId);
    }
}
