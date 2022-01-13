package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.model.Location;
import com.photolib.app.photolibapp.repository.LocationRepository;
import com.photolib.app.photolibapp.service.PhotoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PhotoService photoService;

    @GetMapping("/locations")
    ResponseEntity<List<Location>> all() {
        return ResponseEntity.ok().body(locationRepository.findAll());
    }

    @GetMapping("/location")
    String locationForm(Model model) {
        model.addAttribute("location", new Location());
        return "location";
    }

    @PostMapping("/location")
    String locationSubmit(@ModelAttribute Location location) {
        locationRepository.save(location);
        photoService.findPhotos(location);
        return "redirect:/locations";
    }
}
