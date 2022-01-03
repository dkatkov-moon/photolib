package com.photolib.app.photolibapp.configuration;

import com.photolib.app.photolibapp.entity.PhotoFile;
import com.photolib.app.photolibapp.repository.PhotoFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PhotoFileRepository photoFileRepository) {
        return args -> {
            log.info("Preloading {}", photoFileRepository.save(new PhotoFile("c:/temp/1.png", "1.png")));
            log.info("Preloading {}", photoFileRepository.save(new PhotoFile("c:/temp/2.png", "2.png")));
        };
    }
}
