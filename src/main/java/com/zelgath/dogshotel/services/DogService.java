package com.zelgath.dogshotel.services;

import com.zelgath.dogshotel.domain.Dog;
import com.zelgath.dogshotel.domain.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> getAllDogs() {
        return new ArrayList<>(dogRepository.getAllDogs());
    }

    public void saveDog(Dog dog) {
        dogRepository.createDog(dog);
    }

    public Dog getDog(Integer id) {
        return dogRepository.getDogById(id);
    }

    public void removeDog(Integer id) {
        dogRepository.removeDog(id);
    }

    public void updateDog(Dog dog) {
        dogRepository.updateDog(dog.getId(), dog);
    }

    public void removeCageFromDog(Integer id) {
        dogRepository.removeCageFromDog(id);
    }

    public Set<String> getAllSexTypes() {
        return dogRepository.getAllSexTypes();
    }

    public void removeOwnerCharge(Integer id) {
        dogRepository.ownerHasPaid(id);
    }

}
