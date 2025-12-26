package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles") 
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "User cannot be null")
    private UserEntity user;

    @Column(name = "vehicle_number", unique = true, nullable = false)
    @NotNull(message = "Vehicle number cannot be null")
    private String vehicleNumber;

    @Min(value = 0, message = "Capacity must be greater than or equal to 0")
    private Double capacityKg;

    private Double fuelEfficiency; 
}
