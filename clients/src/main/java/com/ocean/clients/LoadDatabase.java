package com.ocean.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ocean.clients.entity.Client;
import com.ocean.clients.repository.ClientRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ClientRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Client("Ivan", "Bibov", "89999999999")));
            log.info("Preloading " + repository.save(new Client("Pavel", "Bobov", "89999999998")));
        };
    }
}



