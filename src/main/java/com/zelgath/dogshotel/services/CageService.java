package com.zelgath.dogshotel.services;

import com.zelgath.dogshotel.domain.Cage;
import com.zelgath.dogshotel.domain.Dog;
import com.zelgath.dogshotel.domain.repositories.CageRepository;
import com.zelgath.dogshotel.domain.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CageService {

    Random rand = new Random();

    @Autowired
    DogRepository dogRepository;

    CageRepository cageRepository;

    public List<Cage> getAllCages() {
        return new ArrayList<>(cageRepository.getAllCages());
    }

    public void assignRandomCage(String dogName) {
        List<Cage> allCages = cageRepository.getAllCages();
        Cage randomCage = allCages.get(rand.nextInt(allCages.size()));
        dogRepository.getDogByName(dogName).ifPresent(dog -> dog.setCage(randomCage));
    }


    public List<Cage> getAllNotOccupiedCages() {
        return cageRepository.getAllCages().stream().filter(cage -> !cage.isOccupied()).collect(Collectors.toList());
    }

    @Autowired
    public void setCageRepository(CageRepository cageRepository) {
        this.cageRepository = cageRepository;
    }

    public void update(Cage cage) {
        cageRepository.update(cage);
    }
}
