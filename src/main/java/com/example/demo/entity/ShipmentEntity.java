package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipments")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each shipment is assigned to ONE vehicle
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicle;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id", nullable = false)
    private LocationEntity pickupLocation;


    @ManyToOne
    @JoinColumn(name = "drop_location_id", nullable = false)
    private LocationEntity dropLocation;

    @Min(1)
    private double weightKg;

    @NotNull
    private LocalDate scheduledDate;
}
