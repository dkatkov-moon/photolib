package com.photolib.app.photolibapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String absolutePath;
    private String filename;

    @OneToOne
    private Location location;

    public boolean isActive;

    public Photo(String absolutePath, String filename) {
        this.absolutePath = absolutePath;
        this.filename = filename;
    }
}
