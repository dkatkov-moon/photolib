package com.photolib.app.photolibapp.service.search;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

@Slf4j
public class ImageFileMatcher {
    private final Path path;
    private final BasicFileAttributes basicFileAttributes;
    private final String extension;

    public ImageFileMatcher(Path path, BasicFileAttributes basicFileAttributes) {
        this.path = path;
        this.basicFileAttributes = basicFileAttributes;
        this.extension = FilenameUtils.getExtension(path.toString());
    }

    public static final String[] IMAGE_EXTENSIONS = new String[]{"png", "PNG", "jpg", "JPG", "jpeg", "JPEG"};

    public boolean isImage() {
        if (Files.isDirectory(path) || basicFileAttributes.isSymbolicLink()) {
            log.info("Image file {} is directory or symbolic link", path);
            return false;
        }

        if (basicFileAttributes.size() == 0) {
            log.info("Image file {} is empty", path);
            return false;
        }
        return Arrays.asList(IMAGE_EXTENSIONS).contains(extension);
    }

}
