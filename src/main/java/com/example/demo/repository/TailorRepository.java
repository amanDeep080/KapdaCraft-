package com.example.demo.repository;



import com.example.demo.model.TailorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TailorRepository extends JpaRepository<TailorProfile, Long> {
    List<TailorProfile> findByCityIgnoreCase(String city);
}