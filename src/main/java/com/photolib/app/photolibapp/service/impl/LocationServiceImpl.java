package com.photolib.app.photolibapp.service.impl;

import com.photolib.app.photolibapp.model.Location;
import com.photolib.app.photolibapp.repository.LocationRepository;
import com.photolib.app.photolibapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location create(Location location) {
        return locationRepository.save(new Location(location.getPath()));
    }

    @Override
    public Long delete(Long id) {
        locationRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Location> getAllActive() {
        return locationRepository.getAllActive();
    }

    @Override
    public Location getById(Long id) {
        return locationRepository.getById(id);
    }
}
