package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String vehicleNumber;

    private Double capacityKg;
    private Double fuelEfficiency; // km per liter

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude       // Prevents infinite loop in logs
    @JsonIgnore             // Prevents infinite loop in API responses (optional, but recommended)
    private User user;
}