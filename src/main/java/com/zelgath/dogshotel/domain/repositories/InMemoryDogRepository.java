package com.zelgath.dogshotel.domain.repositories;

import com.zelgath.dogshotel.domain.Dog;
import com.zelgath.dogshotel.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.*;


public class InMemoryDogRepository implements DogRepository {


    Map<Integer, Dog> dogs = new HashMap<>();
    Set<String> sexTypes = new HashSet<>();

    @Override
    @PostConstruct
    public void createSexTypes() {
        sexTypes.add("Pies");
        sexTypes.add("Suczka");
        sexTypes.add("Wykastrowany Pies");
        sexTypes.add("Wysterylizowana Suczka");
    }

    @Override
    public Set<String> getAllSexTypes() {
        return sexTypes;
    }


    public InMemoryDogRepository() {
    }

    @Override
    public void createDog(Dog dog) {
        dog.setId(Ids.generateNewId(dogs.keySet()));
        dogs.put(dog.getId(), dog);
    }

    @Override
    public void createDog(String name, String race, int age, String sex, String ownerFullName, int ownerPhoneNumber) {
        Dog newDog = new Dog(name, race, age, sex, ownerFullName, ownerPhoneNumber);
        newDog.setId(Ids.generateNewId(dogs.keySet()));
        dogs.put(newDog.getId(), newDog );

    }


    @Override
    public Collection<Dog> getAllDogs() {
        return dogs.values();
    }

    @Override
    public Optional<Dog> getDogByName(String name) {
        Optional<Dog> dogByName = dogs.values().stream().filter(dog -> dog.getName().equals(name)).findAny();
        return dogByName;
    }

    @Override
    public Dog getDogById(Integer id) {
       return dogs.get(id);
    }

    @Override
    public void removeDog(Integer id) {
        dogs.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {

    }



    @Override
    public void updateDog(int id, Dog dog) {
        dog.setEndOfStayDate();
        dog.setOwnerCharge(dog.getDurationOfStayInDays()*dog.getCage().getPrice());
        dogs.put(id, dog);
    }

    @Override
    public void ownerHasPaid(int id) {
        dogs.get(id).setOwnerCharge(0);
    }

    @Override
    public void removeCageFromDog(Integer id) {
        dogs.get(id).setNullCage();
    }

    @Override
    public String toString() {
        return "InMemoryDogRepository{" +
                "dogs=" + dogs +
                '}';
    }
}
