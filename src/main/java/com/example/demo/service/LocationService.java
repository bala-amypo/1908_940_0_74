package com.example.demo.service;

import com.example.demo.entity.Location;
import java.util.List;

public interface LocationService {

    Location saveLocation(Location location);

    List<Location> getAllLocations();

    Location getLocationById(Long id);
}
