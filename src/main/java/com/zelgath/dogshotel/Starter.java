package com.zelgath.dogshotel;

import com.zelgath.dogshotel.domain.Cage;
import com.zelgath.dogshotel.domain.Dog;
import com.zelgath.dogshotel.domain.repositories.CageRepository;
import com.zelgath.dogshotel.domain.repositories.DogRepository;
import com.zelgath.dogshotel.domain.repositories.InMemoryCageRepository;
import com.zelgath.dogshotel.domain.repositories.InMemoryDogRepository;
import com.zelgath.dogshotel.services.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

@Component
@Transactional
public class Starter implements CommandLineRunner {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    CageRepository cageRepository;

    @Autowired
    CageService cageService;

    @Override
    public void run(String... strings) throws Exception {

        List<Cage> cages = cageRepository.getAllCages();

        for (Cage cage: cages) {
            System.out.println(cage);
        }

        Dog dog = new Dog("Spike", "Border Collie", 4, "Wykastrowany Pies", "Sebastian Mataczyński", 730941112);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));


    }
}
