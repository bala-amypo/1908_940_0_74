package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleServiceImpl(VehicleRepository vRepo, UserRepository uRepo) {
        this.vehicleRepository = vRepo;
        this.userRepository = uRepo;
    }

    @Override
    public Vehicle addVehicle(Long userId, Vehicle vehicle) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        vehicle.setUser(user);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
    }

    @Override
    public List<Vehicle> getVehiclesByUser(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }
}
