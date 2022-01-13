package com.photolib.app.photolibapp.service.search.impl;

import com.photolib.app.photolibapp.repository.PhotoRepository;
import com.photolib.app.photolibapp.service.search.ImageFileMatcher;
import com.photolib.app.photolibapp.service.search.PhotoSearch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class PhotoSearchImpl implements PhotoSearch {

    @Override
    public List<Path> listPhotos(String path) {
        List<Path> paths = new ArrayList<>();
        try (Stream<Path> pathStream = Files.find(Paths.get(path), Integer.MAX_VALUE,
                (p, basicFileAttributes) -> new ImageFileMatcher(p, basicFileAttributes).isImage())) {
            paths.addAll(pathStream.collect(Collectors.toList()));
        } catch (IOException ioException) {
            log.warn(ioException.getMessage());
        }
        return paths;
    }
}
