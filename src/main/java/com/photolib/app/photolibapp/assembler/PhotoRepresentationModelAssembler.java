package com.photolib.app.photolibapp.assembler;

import com.photolib.app.photolibapp.controller.v1.IndexController;
import com.photolib.app.photolibapp.controller.v1.PhotoController;
import com.photolib.app.photolibapp.model.Photo;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PhotoRepresentationModelAssembler implements RepresentationModelAssembler<Photo, EntityModel<Photo>> {
    @Override
    public EntityModel<Photo> toModel(Photo entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(PhotoController.class).getById(entity.getId())).withSelfRel(),
                linkTo(methodOn(IndexController.class).getPhotos()).withRel("photos"));
    }
}
