package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.web.bind.annotation.*;

@RestController

public class RouteOptimizationController {

    private final RouteOptimizationService routeService;

    public RouteOptimizationController(RouteOptimizationService rs) {
        this.routeService = rs;
    }

    @GetMapping("/result/{id}")
    public RouteOptimizationResultEntity getResult(@PathVariable Long id) {
        return routeService.getResult(id);
    }
}
