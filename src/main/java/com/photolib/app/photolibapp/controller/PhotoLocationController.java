package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.model.PhotoLocation;
import com.photolib.app.photolibapp.repository.PhotoLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PhotoLocationController {
    private final PhotoLocationRepository photoLocationRepository;

    @GetMapping("/locations")
    List<PhotoLocation> all() {
        return photoLocationRepository.findAll();
    }
}
