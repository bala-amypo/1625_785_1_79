package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.JpaRepository;
import com.example.demo.entity.UserEntity;
@Repository
public Interface  userrepository extends JpaRepository<UserEntity,Long>{
} 
