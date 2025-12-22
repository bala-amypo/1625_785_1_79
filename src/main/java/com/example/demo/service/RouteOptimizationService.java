package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationEntity;

public interface RouteOptimizationService {
    RouteOptimizationEntity optimizeRoute(Long shipmentId);
    RouteOptimizationEntity getResult(Long id);
}
