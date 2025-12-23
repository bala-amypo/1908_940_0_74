package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService service) {
        this.locationService = service;
    }

    // ➕ Create a new location
    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }


    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }
}
