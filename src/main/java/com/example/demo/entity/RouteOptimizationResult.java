package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeName;
    private double totalDistance;

    @ManyToMany
    @JoinTable(
        name = "result_shipments",
        joinColumns = @JoinColumn(name = "result_id"),
        inverseJoinColumns = @JoinColumn(name = "shipment_id")
    )
    private List<Shipment> shipments;

    public RouteOptimizationResult() {}

    public RouteOptimizationResult(String routeName, double totalDistance, List<Shipment> shipments) {
        this.routeName = routeName;
        this.totalDistance = totalDistance;
        this.shipments = shipments;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }

    public double getTotalDistance() { return totalDistance; }
    public void setTotalDistance(double totalDistance) { this.totalDistance = totalDistance; }

    public List<Shipment> getShipments() { return shipments; }
    public void setShipments(List<Shipment> shipments) { this.shipments = shipments; }
}
