package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "route_optimizations")
public class RouteOptimizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Shipment cannot be null")
    private String shipment; 

    @Min(value = 0, message = "Optimized distance must be >= 0")
    private double optimizedDistanceKm;

    @Min(value = 0, message = "Estimated fuel usage must be >= 0")
    private double estimatedFuelUsageL;

    @Column(nullable = false)
    private LocalDateTime generatedAt = LocalDateTime.now(); 
}
