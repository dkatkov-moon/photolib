package com.photolib.app.photolibapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class PhotoLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String path;
    private int locationType;
    private boolean isActive;

    public PhotoLocation(String path) {
        this.path = path;
    }

    public PhotoLocation(String path, int locationType) {
        this.path = path;
        this.locationType = locationType;
    }
}
