package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.model.Location;
import com.photolib.app.photolibapp.service.LocationService;
import com.photolib.app.photolibapp.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/location")
@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private PhotoService photoService;

    @GetMapping("/{id}")
    ResponseEntity<Location> getById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(locationService.getById(id));
    }

    @PostMapping
    ResponseEntity<Location> create(@RequestBody Location location) {
        locationService.create(location);
        photoService.scanPhotos(location);
        return ResponseEntity.ok().body(location);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(locationService.delete(id));
    }
}
