package com.zelgath.dogshotel.config;

import com.zelgath.dogshotel.domain.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MainConfig {

    @Bean(name = "inMemoryDogRepository")
    @Profile("dev")
    public DogRepository createInMemoryDogRepository(){
        DogRepository repository = new InMemoryDogRepository();
        return repository;
    }

    @Bean(name = "inMemoryCageRepository")
    @Profile("dev")
    public CageRepository createInMemoryCageRepository(){
        CageRepository repository = new InMemoryCageRepository();
        return repository;
    }

    @Bean(name = "DBDogRepository")
    @Profile("prod")
    public DogRepository createDBDogRepository(){
        DogRepository repository = new DBDogRepository();
        return repository;
    }

    @Bean(name = "DBCageRepository")
    @Profile("prod")
    public CageRepository createDBCageRepository(){
        CageRepository repository = new DBCageRepository();
        return repository;
    }

}
