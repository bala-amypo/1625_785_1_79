
package com.example.demo.entity;
import org.springframework.stereotype.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.NotNull;
import jakarta.validation.Column;
import jakarta.validation.Max;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LocationEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
 @NotNull
    private String name;
    @Max(90)
    private Double latitude;
    private Double longtitude; 

}