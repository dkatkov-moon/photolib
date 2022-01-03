package com.photolib.app.photolibapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Data
@NoArgsConstructor
@Entity
public class PhotoFile {

    @Id
    @GeneratedValue
    private long id;

    private String absolutePath;
    private String filename;

    public PhotoFile(String absolutePath, String filename) {
        this.absolutePath = absolutePath;
        this.filename = filename;
    }
}
