package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "route_optimizations")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shipment_id", nullable = false)
    @NotNull
    private Shipment shipment;

    @Min(0)
    private double optimizedDistanceKm;

    @Min(0)
    private double estimatedFuelUsageL;

    @Column(nullable = false)
    private LocalDateTime generatedAt = LocalDateTime.now();
}
