package com.photolib.app.photolibapp.service.impl;

import com.photolib.app.photolibapp.model.Location;
import com.photolib.app.photolibapp.model.Photo;
import com.photolib.app.photolibapp.repository.PhotoRepository;
import com.photolib.app.photolibapp.service.PhotoService;
import com.photolib.app.photolibapp.service.search.PhotoSearch;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoSearch photoSearch;

    @Override
    public Photo create(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo getById(Long id) {
        return photoRepository.getById(id);
    }

    @Override
    public List<Photo> getAllActive() {
        return photoRepository.getAllActive();
    }

    @Override
    public Long delete(Long id) {
        photoRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Photo> scanPhotos(Location location) {
        List<Photo> photos = photoSearch.listPhotos(location.getPath()).stream()
                .map(path -> new Photo(path.toString(), FilenameUtils.getName(path.toString()), location))
                .collect(Collectors.toList());
        return photoRepository.saveAll(photos);
    }
}
