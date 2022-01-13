package com.photolib.app.photolibapp.repository;

import com.photolib.app.photolibapp.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    default List<Photo> getAllActive() {
        return getAllByStatus(1);
    }

    @Query("SELECT p FROM Photo p  WHERE p.status = :status")
    List<Photo> getAllByStatus(@Param("status") int status);
}
