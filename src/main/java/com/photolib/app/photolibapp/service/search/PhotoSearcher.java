package com.photolib.app.photolibapp.service.search;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class PhotoSearcher {
    public static List<Path> listFiles(String path) {
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
