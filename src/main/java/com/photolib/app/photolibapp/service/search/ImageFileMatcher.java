package com.photolib.app.photolibapp.service.search;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

@Slf4j
@AllArgsConstructor
public class ImageFileMatcher {
    private final Path path;
    private final BasicFileAttributes basicFileAttributes;

    public boolean isImage() {
        if (Files.isDirectory(path) || basicFileAttributes.isSymbolicLink()) {
            log.info("Image file {} is directory or symbolic link", path);
            return false;
        }

        if (basicFileAttributes.size() == 0) {
            log.info("Image file {} is empty", path);
            return false;
        }
        return true;
    }
}
