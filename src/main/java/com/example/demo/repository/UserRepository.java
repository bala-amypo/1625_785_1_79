package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.UserEntity;
import java.util.*;
@Repository
public interface  UserRepository extends JpaRepository<UserEntity,Long>{
     Optional<UserEntity> findByEmail(String email);
} 
