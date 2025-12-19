package com.example.demo.entity;
import org.springframework.stereotype.Entity;
import jakarta.persistence.I
@Entity
public class UserEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

}