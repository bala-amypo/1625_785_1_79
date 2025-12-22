package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locations")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Location name cannot be null")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Latitude cannot be null")
    @Min(value = -90, message = "Latitude must be >= -90")
    @Max(value = 90, message = "Latitude must be <= 90")
    private Double latitude;

    @NotNull(message = "Longitude cannot be null")
    @Min(value = -180, message = "Longitude must be >= -180")
    @Max(value = 180, message = "Longitude must be <= 180")
    private Double longitude;
}
