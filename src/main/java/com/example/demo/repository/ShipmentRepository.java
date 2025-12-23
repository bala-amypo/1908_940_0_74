package com.example.demo.repository;

import com.example.demo.entity.Shipment;
import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {
    Optional<Shipment> findById(Long id);
    List<Shipment> findByVehicleId(Long vehicleId);
    Shipment save(Shipment shipment);
}
