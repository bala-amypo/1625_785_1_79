package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.JpaRepository;
import com.example.demo.entity.ShipmentEntity;
@Repository
public interface  shipmentrepository extends JpaRepository<ShipmentEntity,Long>{
} 
