package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResultEntity;

public interface RouteOptimizationService {
    RouteOptimizationResultEntity optimizeRoute(Long shipmentId);
    RouteOptimizationResultEntity getResult(Long id);
}
