package com.example.demo.service;

import com.example.demo.entity.Location;
import java.util.List;

public interface LocationService {
    Location saveLocation(Location l); // match controller
    Location getLocationById(Long id); // add if missing
    List<Location> getAllLocations();
}

