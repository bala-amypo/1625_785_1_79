package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.JpaRepository;
import com.example.demo.entity.VehicleEntity;
@Repository
public Interface  vehiclerepository extends JpaRepository<VehicleEntity,Long>{
} 
