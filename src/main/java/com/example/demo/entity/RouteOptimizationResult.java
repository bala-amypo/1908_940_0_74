package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeName;          // Name of the optimized route
    private double totalDistance;      // Total distance of the route

    @ManyToMany
    @JoinTable(
        name = "result_shipments",
        joinColumns = @JoinColumn(name = "result_id"),
        inverseJoinColumns = @JoinColumn(name = "shipment_id")
    )
    private List<com.example.demo.entity.Shipment> shipments;  // Shipments in this route

    // Constructors
    public RouteOptimizationResult() {}

    public RouteOptimizationResult(String routeName, double totalDistance, List<com.example.demo.entity.Shipment> shipments) {
        this.routeName = routeName;
        this.totalDistance = totalDistance;
        this.shipments = shipments;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }

    public double getTotalDistance() { return totalDistance; }
    public void setTotalDistance(double totalDistance) { this.totalDistance = totalDistance; }

    public List<com.example.demo.entity.Shipment> getShipments() { return shipments; }
    public void setShipments(List<com.example.demo.entity.Shipment> shipments) { this.shipments = shipments; }
}
