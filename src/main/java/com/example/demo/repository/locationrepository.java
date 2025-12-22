package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.JpaRepository;
import com.example.demo.entity.LocationEntity;
@Repository
public interface  locationrepository extends JpaRepository<LocationEntity,Long>{
} 
