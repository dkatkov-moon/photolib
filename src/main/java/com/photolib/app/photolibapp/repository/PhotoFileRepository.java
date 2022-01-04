package com.photolib.app.photolibapp.repository;

import com.photolib.app.photolibapp.model.PhotoFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoFileRepository extends JpaRepository<PhotoFile, Long> {
}
