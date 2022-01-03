package com.photolib.app.photolibapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoFileController {
    @GetMapping("/photo-file")
    public PhotoFile photoFile(@RequestParam(value = "name", defaultValue = "sample.png") String name) {
        return new PhotoFile(1, "C:/temp/temp.png", "temp.png");
    }
}
