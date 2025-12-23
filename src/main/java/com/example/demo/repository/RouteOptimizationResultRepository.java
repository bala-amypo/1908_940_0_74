package com.example.demo.repository;

import com.example.demo.entity.RouteOptimizationResult;
import java.util.Optional;

public interface RouteOptimizationResultRepository {
    Optional<RouteOptimizationResult> findById(Long id);
    RouteOptimizationResult save(RouteOptimizationResult result);
}
