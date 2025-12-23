package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.ShipmentService;

public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final VehicleRepository vehicleRepository;
    private final LocationRepository locationRepository;

    public ShipmentServiceImpl(ShipmentRepository sRepo, VehicleRepository vRepo, LocationRepository lRepo) {
        this.shipmentRepository = sRepo;
        this.vehicleRepository = vRepo;
        this.locationRepository = lRepo;
    }

    @Override
    public Shipment createShipment(Long vehicleId, Shipment shipment) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        shipment.setVehicle(vehicle);
        shipment.setPickupLocation(
                locationRepository.findById(shipment.getPickupLocation().getId()).orElseThrow()
        );
        shipment.setDropLocation(
                locationRepository.findById(shipment.getDropLocation().getId()).orElseThrow()
        );

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipment(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
