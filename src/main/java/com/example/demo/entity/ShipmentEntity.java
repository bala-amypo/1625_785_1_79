package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShipmentEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
     @JoinColumn(name="vehicle_id",nullable=false)
    private VehicleEntity id;
    private String vehicle;
    @ManyToOne
       @JoinColumn(name="location_id",nullable=false)
    private LocationEntity id;
    private String pickupLocation;
    @ManyToOne
       @JoinColumn(name="location_id",nullable=false)
    private LocationEntity id;
    private String dropLocation;
    private double weightKg;
    private LocalDate scheduledDate;

}