package com.photolib.app.photolibapp.service;

import com.photolib.app.photolibapp.model.Photo;
import com.photolib.app.photolibapp.model.Location;

import java.util.List;

public interface PhotoService {
    Photo create(Photo photo);
    Photo getById(Long id);
    List<Photo> getAllActive();
    Long delete(Long id);
    List<Photo> scanPhotos(Location location);
}
