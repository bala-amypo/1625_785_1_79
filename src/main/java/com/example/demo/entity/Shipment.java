package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id", nullable = false)
    private Location pickupLocation;

    @ManyToOne
    @JoinColumn(name = "drop_location_id", nullable = false)
    private Location dropLocation;

    @Min(1)
    private double weightKg;

    @NotNull
    private LocalDate scheduledDate;
}
