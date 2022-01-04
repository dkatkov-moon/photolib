package com.photolib.app.photolibapp.assembler;

import com.photolib.app.photolibapp.controller.PhotoFileController;
import com.photolib.app.photolibapp.model.PhotoFile;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PhotoFileModelAssembler implements RepresentationModelAssembler<PhotoFile, EntityModel<PhotoFile>> {
    @Override
    public EntityModel<PhotoFile> toModel(PhotoFile entity) {
        return EntityModel.of(entity,
                linkTo(methodOn(PhotoFileController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(PhotoFileController.class).all()).withRel("photo-files"));
    }
}
