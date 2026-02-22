package com.example.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.FabricRequest;

public interface FabricRepository extends JpaRepository<FabricRequest, Long> {
}