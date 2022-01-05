package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.model.PhotoLocation;
import com.photolib.app.photolibapp.repository.PhotoLocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PhotoLocationController {
    private final PhotoLocationRepository photoLocationRepository;

    @GetMapping("/locations")
    ResponseEntity<List<PhotoLocation>> all() {
        return ResponseEntity.ok().body(photoLocationRepository.findAll());
    }

    @GetMapping("/location")
    String locationForm(Model model) {
        model.addAttribute("photoLocation", new PhotoLocation());
        return "location";
    }

    @PostMapping("/location")
    String locationSubmit(@ModelAttribute PhotoLocation photoLocation) {
        photoLocationRepository.save(photoLocation);
        return "redirect:/locations";
    }
}
