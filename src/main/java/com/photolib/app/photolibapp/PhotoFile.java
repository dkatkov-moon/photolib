package com.photolib.app.photolibapp;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PhotoFile {


    @Id
    private final long id;

    private final String absolutePath;
    private final String filename;
}
