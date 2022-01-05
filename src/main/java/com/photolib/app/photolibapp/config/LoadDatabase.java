package com.photolib.app.photolibapp.config;

import com.photolib.app.photolibapp.model.PhotoFile;
import com.photolib.app.photolibapp.model.PhotoLocation;
import com.photolib.app.photolibapp.repository.PhotoFileRepository;
import com.photolib.app.photolibapp.repository.PhotoLocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initPhotoFiles(PhotoFileRepository photoFileRepository) {
        return args -> {
            log.info("Preloading file {}", photoFileRepository.save(new PhotoFile("c:/temp/1.png", "1.png")));
            log.info("Preloading file {}", photoFileRepository.save(new PhotoFile("c:/temp/2.png", "2.png")));
        };
    }

    @Bean
    CommandLineRunner initPhotoLocations(PhotoLocationRepository photoLocationRepository) {
        return args -> {
            log.info("Preloading location {}", photoLocationRepository.save(new PhotoLocation("c:/temp/")));
        };
    }
}
