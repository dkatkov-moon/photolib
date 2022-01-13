package com.photolib.app.photolibapp.repository;

import com.photolib.app.photolibapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    default List<Location> getAllActive() {
        return getAllByStatus(1);
    }

    @Query("SELECT l FROM Location l  WHERE l.status = :status")
    List<Location> getAllByStatus(@Param("status") int status);
}
