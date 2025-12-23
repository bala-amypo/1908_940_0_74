package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/optimization")
@RequiredArgsConstructor
public class RouteOptimizationController {
    private final RouteOptimizationService routeService;

    @PostMapping("/{shipmentId}")
    public RouteOptimizationResult optimize(@PathVariable Long shipmentId) {
        return routeService.optimizeRoute(shipmentId);
    }

    @GetMapping("/{id}")
    public RouteOptimizationResult getResult(@PathVariable Long id) {
        return routeService.getResult(id);
    }
}