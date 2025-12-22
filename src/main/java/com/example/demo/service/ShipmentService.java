package com.example.demo.service;

import com.example.demo.entity.ShipmentEntity;

public interface ShipmentService {
    ShipmentEntity createShipment(Long vehicleId, ShipmentEntity shipment);
    ShipmentEntity getShipment(Long id);
}
