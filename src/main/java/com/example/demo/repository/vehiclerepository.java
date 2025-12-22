package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.VehicleEntity;
@Repository
public interface  vehiclerepository extends JpaRepository<VehicleEntity,Long>{
} 
