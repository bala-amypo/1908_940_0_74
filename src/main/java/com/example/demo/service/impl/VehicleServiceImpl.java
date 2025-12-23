package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.VehicleService;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;
    private final UserRepository userRepo;

    public VehicleServiceImpl(VehicleRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    public Vehicle addVehicle(Long userId, Vehicle v) {
        if (v.getCapacityKg() <= 0)
            throw new IllegalArgumentException("Capacity must be positive");

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        v.setUser(user);
        return repo.save(v);
    }

    public List<Vehicle> getVehiclesByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public Vehicle findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
    }
}
