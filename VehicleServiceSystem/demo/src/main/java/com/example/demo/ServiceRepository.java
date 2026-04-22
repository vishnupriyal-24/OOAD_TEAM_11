package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceRepository extends JpaRepository<ServiceRequest, Long> {
    List<ServiceRequest> findByVehicle(String vehicle);
}