package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationEntity;

public interface RouteOptimizationService {
    RouteOptimizationResultEntity optimizeRoute(Long shipmentId);
    RouteOptimizationResultEntity getResult(Long id);
}
