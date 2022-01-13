package com.photolib.app.photolibapp.service.search;

import java.nio.file.Path;
import java.util.List;

public interface PhotoSearch {
        List<Path> listPhotos(String path);
}
