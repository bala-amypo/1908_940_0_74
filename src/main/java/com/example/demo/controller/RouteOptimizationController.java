package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResult;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteOptimizationController {

    private final RouteOptimizationService service;

    public RouteOptimizationController(RouteOptimizationService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public ResponseEntity<RouteOptimizationResult> saveRoute(@RequestBody RouteOptimizationResult result) {
        RouteOptimizationResult saved = service.saveRouteResult(result);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<RouteOptimizationResult>> getAllRoutes() {
        List<RouteOptimizationResult> results = service.getAllResults();
        return ResponseEntity.ok(results);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteOptimizationResult> getRouteById(@PathVariable Long id) {
        RouteOptimizationResult result = service.getResultById(id);
        if (result == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }
}
