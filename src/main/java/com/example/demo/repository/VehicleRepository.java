package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.VehicleEntity;
import java.util.*;
@Repository
public interface  VehicleRepository extends JpaRepository<VehicleEntity,Long>{
      List<VehicleEntity> findByUserId(Long userId);
} 
