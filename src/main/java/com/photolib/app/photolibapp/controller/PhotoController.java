package com.photolib.app.photolibapp.controller;

import com.photolib.app.photolibapp.assembler.PhotoModelAssembler;
import com.photolib.app.photolibapp.exception.PhotoFileNotFoundException;
import com.photolib.app.photolibapp.model.Photo;
import com.photolib.app.photolibapp.repository.PhotoRepository;
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
public class PhotoController {

    private final PhotoRepository photoRepository;
    private final PhotoModelAssembler photoModelAssembler;

    @GetMapping("/photos")
    public CollectionModel<EntityModel<Photo>> all() {
        List<EntityModel<Photo>> photos = photoRepository.findAll().stream().map(photoModelAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(photos, linkTo(methodOn(PhotoController.class).all()).withSelfRel());
    }

    @GetMapping("/photo/{id}")
    public EntityModel<Photo> one(@PathVariable Long id) {
        return photoRepository.findById(id)
                .map(photoModelAssembler::toModel)
                .orElseThrow(() -> new PhotoFileNotFoundException(id));
    }

    @PutMapping("/photo/{id}")
    EntityModel<Photo> updateOrNew(@RequestBody Photo newPhoto, @PathVariable Long id) {
        Photo photo = photoRepository.findById(id)
                .map(ph -> {
                    ph.setFilename(newPhoto.getFilename());
                    ph.setAbsolutePath(newPhoto.getAbsolutePath());
                    return ph;
                }).orElseGet(() -> {
                    newPhoto.setId(id);
                    return newPhoto;
                });
        photo = photoRepository.save(photo);
        return photoModelAssembler.toModel(photo);
    }

    @DeleteMapping("/photo/{id}")
    void deletePhotoFile(@PathVariable Long id) {
        photoRepository.deleteById(id);
    }
}
