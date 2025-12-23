package com.example.demo.repository;

import com.example.demo.entity.Location;
import java.util.List;
import java.util.Optional;

public interface LocationRepository {
    Optional<Location> findById(Long id);
    List<Location> findAll();
    Location save(Location location);
}
