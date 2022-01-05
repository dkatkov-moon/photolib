package com.photolib.app.photolibapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class PhotoFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String absolutePath;
    private String filename;

    public boolean isActive;

    public PhotoFile(String absolutePath, String filename) {
        this.absolutePath = absolutePath;
        this.filename = filename;
    }
}
