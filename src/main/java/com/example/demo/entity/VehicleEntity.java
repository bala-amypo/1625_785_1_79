
package com.example.demo.entity;
import org.springframework.stereotype.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.NotNull;
import jakarta.validation.Column;
import jakarta.validation.Min;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VehicleEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="vehicleNumber",unique=true)
    private String vehicleNumber;
    @Min(0)
    private Double capacityKg;
    private Double fuelEfficiency; 

}