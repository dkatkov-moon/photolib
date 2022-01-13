package com.photolib.app.photolibapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FilenameUtils;

import javax.persistence.*;

import static com.photolib.app.photolibapp.model.Photo.TABLE;

@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE)
public class Photo {

    public static final String TABLE = "PHOTO";

    public static final String TABLE_SEQ = TABLE + "_SQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ, allocationSize = 500)
    private long id;

    private String absolutePath;

    private String filename;

    @OneToOne
    private Location location;

    private int status = 1;

    public Photo(String absolutePath, String filename) {
        this.absolutePath = absolutePath;
        this.filename = filename;
    }

    public Photo(String absolutePath, String filename, Location location) {
        this(absolutePath, filename);
        this.location = location;
    }
}
