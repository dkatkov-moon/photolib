package com.photolib.app.photolibapp.service;

import com.photolib.app.photolibapp.model.Photo;
import com.photolib.app.photolibapp.model.Location;

import java.util.List;

public interface PhotoService {
    List<Photo> findPhotos(Location location);
}
