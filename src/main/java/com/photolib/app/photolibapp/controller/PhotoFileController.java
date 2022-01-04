package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.assembler.PhotoFileModelAssembler;
import com.photolib.app.photolibapp.exception.PhotoFileNotFoundException;
import com.photolib.app.photolibapp.model.PhotoFile;
import com.photolib.app.photolibapp.repository.PhotoFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@AllArgsConstructor
public class PhotoFileController {

    private final PhotoFileRepository photoFileRepository;
    private final PhotoFileModelAssembler photoFileModelAssembler;

    @GetMapping("/photo-files")
    public CollectionModel<EntityModel<PhotoFile>> all() {
        List<EntityModel<PhotoFile>> photos = photoFileRepository.findAll().stream().map(photoFileModelAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(photos, linkTo(methodOn(PhotoFileController.class).all()).withSelfRel());
    }

    @GetMapping("/photo-file/{id}")
    public EntityModel<PhotoFile> one(@PathVariable Long id) {
        return photoFileRepository.findById(id)
                .map(photoFileModelAssembler::toModel)
                .orElseThrow(() -> new PhotoFileNotFoundException(id));
    }

    @PutMapping("/photo-file/{id}")
    EntityModel<PhotoFile> updateOrNew(@RequestBody PhotoFile newPhotoFile, @PathVariable Long id) {
        PhotoFile photoFile = photoFileRepository.findById(id)
                .map(photo -> {
                    photo.setFilename(newPhotoFile.getFilename());
                    photo.setAbsolutePath(newPhotoFile.getAbsolutePath());
                    return photo;
                }).orElseGet(() -> {
                    newPhotoFile.setId(id);
                    return newPhotoFile;
                });
        photoFile = photoFileRepository.save(photoFile);
        return photoFileModelAssembler.toModel(photoFile);
    }

    @DeleteMapping("/photo-file/{id}")
    void deletePhotoFile(@PathVariable Long id) {
        photoFileRepository.deleteById(id);
    }
}
