package com.photolib.app.photolibapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class PhotoFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String absolutePath;
    private String filename;

    public PhotoFile(String absolutePath, String filename) {
        this.absolutePath = absolutePath;
        this.filename = filename;
    }
}
