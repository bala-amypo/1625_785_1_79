package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteOptimizationController {

    private final RouteOptimizationService routeService;

    public RouteOptimizationController(RouteOptimizationService rs) {
        this.routeService = rs;
    }
    @PostMapping("/optimize/{id}")
    public RouteOptimizationResult optimizeResult(@PathVariable("Shipment_ID") Long id){
        return optimizeRoute(id);
    }
    @GetMapping("/result/{id}")
    public RouteOptimizationResult getResult(@PathVariable Long id) {
        return routeService.getResult(id);
    }
}
