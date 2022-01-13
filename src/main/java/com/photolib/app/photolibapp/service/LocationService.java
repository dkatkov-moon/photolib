package com.photolib.app.photolibapp.service;

import com.photolib.app.photolibapp.model.Location;

import java.util.List;

public interface LocationService {
    Location create(Location location);

    Long delete(Long id);

    List<Location> getAllActive();

    Location getById(Long id);
}
