
package com.example.demo.entity;
import org.springframework.stereotype.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.NotNull;
import jakarta.validation.Column;
@Entity
public class VehicleEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @Email
    @Column(name="vehicleNumber",unique=true)
    private String vehicleNumber;
    private Double password;
    private String role; 

}