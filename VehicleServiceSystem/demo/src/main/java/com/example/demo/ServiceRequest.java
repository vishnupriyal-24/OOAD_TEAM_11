package com.example.demo;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "service_requests")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_number")
    private String vehicle;

    @Column(name = "service_type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_phone")
    private String customerPhone;

    @Column(name = "vehicle_model")
    private String vehicleModel;

    @Column(name = "vehicle_year")
    private Integer vehicleYear;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @Column(name = "completed_date")
    private LocalDateTime completedDate;

    @Column(name = "assigned_to")
    private String assignedTo;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "notes")
    private String notes;

    public ServiceRequest() {
        this.status = "PENDING";
        this.createdDate = LocalDateTime.now();
    }

    public ServiceRequest(String vehicle, String type) {
        this.vehicle = vehicle;
        this.type = type;
        this.status = "PENDING";
        this.createdDate = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getVehicle() { return vehicle; }
    public void setVehicle(String vehicle) { this.vehicle = vehicle; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }

    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }

    public Integer getVehicleYear() { return vehicleYear; }
    public void setVehicleYear(Integer vehicleYear) { this.vehicleYear = vehicleYear; }

    public Long getMileage() { return mileage; }
    public void setMileage(Long mileage) { this.mileage = mileage; }

    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }

    public LocalDateTime getAssignedDate() { return assignedDate; }
    public void setAssignedDate(LocalDateTime assignedDate) { this.assignedDate = assignedDate; }

    public LocalDateTime getCompletedDate() { return completedDate; }
    public void setCompletedDate(LocalDateTime completedDate) { this.completedDate = completedDate; }

    public String getAssignedTo() { return assignedTo; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}