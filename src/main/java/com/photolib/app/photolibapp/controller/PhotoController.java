package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.model.Photo;
import com.photolib.app.photolibapp.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/{id}")
    ResponseEntity<Photo> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(photoService.getById(id));
    }

    @PostMapping
    ResponseEntity<Photo> create(@RequestBody Photo photo) {
        return ResponseEntity.ok().body(photoService.create(photo));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Long> delete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(photoService.delete(id));
    }
}
