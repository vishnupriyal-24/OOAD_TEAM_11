package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@CrossOrigin
public class ServiceController {

    private final ServiceRepository repo;

    public ServiceController(ServiceRepository repo) {
        this.repo = repo;
    }

    // BOOK SERVICE
    @PostMapping("/book")
    public ServiceRequest book(
            @RequestParam String vehicle,
            @RequestParam String type,
            @RequestParam String customerName,
            @RequestParam String customerEmail,
            @RequestParam String customerPhone,
            @RequestParam String vehicleModel,
            @RequestParam Integer vehicleYear,
            @RequestParam Long mileage) {
        
        ServiceRequest service = new ServiceRequest(vehicle, type);
        service.setCustomerName(customerName);
        service.setCustomerEmail(customerEmail);
        service.setCustomerPhone(customerPhone);
        service.setVehicleModel(vehicleModel);
        service.setVehicleYear(vehicleYear);
        service.setMileage(mileage);
        
        return repo.save(service);
    }

    // GET ALL SERVICES (Manager)
    @GetMapping("/services")
    public List<ServiceRequest> getAll() {
        return repo.findAll();
    }

    // CHECK CUSTOMER STATUS
    @GetMapping("/status/{vehicle}")
    public List<ServiceRequest> getStatus(@PathVariable String vehicle) {
        return repo.findByVehicle(vehicle);
    }

    // GET BY ID
    @GetMapping("/service/{id}")
    public ServiceRequest getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // ASSIGN
    @PostMapping("/assign/{id}")
    public ServiceRequest assign(@PathVariable Long id, @RequestParam String assignedTo) {
        ServiceRequest service = repo.findById(id).orElse(null);
        if (service != null) {
            service.setStatus("ASSIGNED");
            service.setAssignedTo(assignedTo);
            service.setAssignedDate(LocalDateTime.now());
            repo.save(service);
        }
        return service;
    }

    // COMPLETE
    @PostMapping("/complete/{id}")
    public ServiceRequest complete(
            @PathVariable Long id,
            @RequestParam Double cost,
            @RequestParam String notes) {
        ServiceRequest service = repo.findById(id).orElse(null);
        if (service != null) {
            service.setStatus("COMPLETED");
            service.setCompletedDate(LocalDateTime.now());
            service.setCost(cost);
            service.setNotes(notes);
            repo.save(service);
        }
        return service;
    }

    // GET STATISTICS
    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        List<ServiceRequest> all = repo.findAll();
        Map<String, Object> stats = new HashMap<>();
        stats.put("total", all.size());
        stats.put("pending", all.stream().filter(s -> "PENDING".equals(s.getStatus())).count());
        stats.put("assigned", all.stream().filter(s -> "ASSIGNED".equals(s.getStatus())).count());
        stats.put("completed", all.stream().filter(s -> "COMPLETED".equals(s.getStatus())).count());
        return stats;
    }
}