package com.photolib.app.photolibapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.photolib.app.photolibapp.model.Location.TABLE;

@Data
@NoArgsConstructor
@Entity
@Table(name = TABLE)
public class Location {

    public static final String TABLE = "LOCATION";

    public static final String TABLE_SEQ = TABLE + "_SQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_SEQ)
    @SequenceGenerator(name = TABLE_SEQ, sequenceName = TABLE_SEQ, allocationSize = 1)
    private long id;

    private String path;

    private int locationType;

    private boolean isActive = true;

    public Location(String path) {
        this.path = path;
    }

    public Location(String path, int locationType) {
        this.path = path;
        this.locationType = locationType;
    }
}
