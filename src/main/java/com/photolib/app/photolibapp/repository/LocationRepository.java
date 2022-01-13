package com.photolib.app.photolibapp.repository;

import com.photolib.app.photolibapp.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
