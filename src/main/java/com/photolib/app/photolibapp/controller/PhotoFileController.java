package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.entity.PhotoFile;
import com.photolib.app.photolibapp.repository.PhotoFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PhotoFileController {

    private final PhotoFileRepository photoFileRepository;

    @GetMapping("/photo-files")
    List<PhotoFile> all() {
        return photoFileRepository.findAll();
    }

    @GetMapping("/photo-file/{id}")
    PhotoFile one(@PathVariable Long id) {
        return photoFileRepository.findById(id).orElseThrow(() -> new IllegalStateException("Photo file with id '" + id + "' not found"));
    }

    @PutMapping("/photo-file/{id}")
    PhotoFile updateOrNew(@RequestBody PhotoFile newPhotoFile, @PathVariable Long id) {
        PhotoFile photoFile = photoFileRepository.findById(id)
                .map(photo -> {
                    photo.setFilename(newPhotoFile.getFilename());
                    photo.setAbsolutePath(newPhotoFile.getAbsolutePath());
                    return photo;
                }).orElseGet(() -> {
                    newPhotoFile.setId(id);
                    return newPhotoFile;
                });
        return photoFileRepository.save(photoFile);
    }

    @DeleteMapping("/photo-file/{id}")
    void deletePhotoFile(@PathVariable Long id) {
        photoFileRepository.deleteById(id);
    }
}
