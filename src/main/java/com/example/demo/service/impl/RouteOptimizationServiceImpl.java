package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RouteOptimizationService;

import java.time.LocalDateTime;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;
    private final RouteOptimizationResultRepository repo;

    public RouteOptimizationServiceImpl(ShipmentRepository s, RouteOptimizationResultRepository r) {
        this.shipmentRepo = s;
        this.repo = r;
    }

    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment s = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double distance = Math.hypot(
                s.getPickupLocation().getLatitude() - s.getDropLocation().getLatitude(),
                s.getPickupLocation().getLongitude() - s.getDropLocation().getLongitude()
        );

        RouteOptimizationResult r = RouteOptimizationResult.builder()
                .shipment(s)
                .optimizedDistanceKm(distance)
                .estimatedFuelUsageL(distance / s.getVehicle().getFuelEfficiency())
                .generatedAt(LocalDateTime.now())
                .build();

        return repo.save(r);
    }

    public RouteOptimizationResult getResult(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
