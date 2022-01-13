package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.model.Location;
import com.photolib.app.photolibapp.model.Photo;
import com.photolib.app.photolibapp.service.LocationService;
import com.photolib.app.photolibapp.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class OverviewController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private PhotoService photoService;

    @GetMapping("/locations")
    ResponseEntity<List<Location>> getLocations() {
        return ResponseEntity.ok().body(locationService.getAllActive());
    }

    @GetMapping("/photos")
    ResponseEntity<List<Photo>> getPhotos() {
        return ResponseEntity.ok().body(photoService.getAllActive());
    }
}
