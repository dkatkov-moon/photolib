package com.photolib.app.photolibapp.config;

import com.photolib.app.photolibapp.model.Location;
import com.photolib.app.photolibapp.model.Photo;
import com.photolib.app.photolibapp.repository.PhotoRepository;
import com.photolib.app.photolibapp.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDatabase {
    @Bean
    CommandLineRunner initPhotoFiles(PhotoRepository photoRepository) {
        return args -> {
            log.info("Preloading file {}", photoRepository.save(new Photo("c:/temp/IMG_9000.JPG", "IMG_9000.JPG")));
            log.info("Preloading file {}", photoRepository.save(new Photo("c:/temp/2.png", "2.png")));
        };
    }

    @Bean
    CommandLineRunner initPhotoLocations(LocationRepository locationRepository) {
        return args -> {
            log.info("Preloading location {}", locationRepository.save(new Location("c:/temp/")));
        };
    }
}
