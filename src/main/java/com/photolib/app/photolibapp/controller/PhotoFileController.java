package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.entity.PhotoFile;
import com.photolib.app.photolibapp.repository.PhotoFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PhotoFileController {

    private final PhotoFileRepository photoFileRepository;

    @GetMapping("/photo-files")
    public List<PhotoFile> all() {
        return photoFileRepository.findAll();
    }

    @GetMapping("/photo-file/{id}")
    public PhotoFile one(@PathVariable Long id) {
        return photoFileRepository.findById(id).orElseThrow(() -> new IllegalStateException("Photo file with id '" + id + "' not found"));
    }
}
