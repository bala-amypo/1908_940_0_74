package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String vehicleNumber;

    @NotNull
    @Min(1)
    private Double capacityKg;

    @NotNull
    @Min(1)
    private Double fuelEfficiency; // km per liter

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
