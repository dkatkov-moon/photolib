package com.photolib.app.photolibapp.repository;

import com.photolib.app.photolibapp.model.PhotoLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoLocationRepository extends JpaRepository<PhotoLocation, Long> {
}
