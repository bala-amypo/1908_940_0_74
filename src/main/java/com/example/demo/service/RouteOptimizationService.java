package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResult;
import java.util.List;

public interface RouteOptimizationService {
    RouteOptimizationResult saveRouteResult(RouteOptimizationResult result);
    List<RouteOptimizationResult> getAllResults();
    RouteOptimizationResult getResultById(Long id);
}
