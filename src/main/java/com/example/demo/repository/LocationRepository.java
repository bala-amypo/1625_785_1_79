package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.LocationEntity;
@Repository
public interface  LocationRepository extends JpaRepository<LocationEntity,Long>{
} 
