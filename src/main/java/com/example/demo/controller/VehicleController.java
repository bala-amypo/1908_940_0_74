package com.example.demo.controller;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("/user/{userId}")
    public Vehicle addVehicle(@PathVariable Long userId, @RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(userId, vehicle);
    }

    @GetMapping("/user/{userId}")
    public List<Vehicle> getUserVehicles(@PathVariable Long userId) {
        return vehicleService.getVehiclesByUser(userId);
    }
}