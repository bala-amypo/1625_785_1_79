
package com.example.demo.entity;
import org.springframework.stereotype.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.NotNull;
import jakarta.validation.Column;
import jakarta.validation.Min;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RouteOptimizationEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private String Shipment;
    private double optimizedDistanceKm;
    private double estimatedFuelUsageL;
    private LocalDateTime generatedAt;

}