package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Column;
import jakarta.validation.constraints.Max;
import jakarta.persistence.ManyToOne;

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
    private String vehicle;
    @ManyToOne
    private String pickupLocation;
    @ManyToOne
    private String dropLocation;
    private double weightKg;
    private LocalDate scheduledDate;

}