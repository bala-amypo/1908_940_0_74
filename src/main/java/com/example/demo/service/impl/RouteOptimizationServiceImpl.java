package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RouteOptimizationService;

import java.time.LocalDateTime;

public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepository;
    private final RouteOptimizationResultRepository resultRepository;

    public RouteOptimizationServiceImpl(ShipmentRepository sRepo, RouteOptimizationResultRepository rRepo) {
        this.shipmentRepository = sRepo;
        this.resultRepository = rRepo;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double distance = Math.sqrt(
                Math.pow(shipment.getPickupLocation().getLatitude() -
                        shipment.getDropLocation().getLatitude(), 2)
                        +
                        Math.pow(shipment.getPickupLocation().getLongitude() -
                                shipment.getDropLocation().getLongitude(), 2)
        );

        RouteOptimizationResult result = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(distance)
                .estimatedFuelUsageL(distance / shipment.getVehicle().getFuelEfficiency())
                .generatedAt(LocalDateTime.now())
                .build();

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResult getResult(Long id) {
        return resultRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
