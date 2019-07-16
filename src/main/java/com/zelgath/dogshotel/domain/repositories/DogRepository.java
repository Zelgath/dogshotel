package com.zelgath.dogshotel.domain.repositories;

import com.zelgath.dogshotel.domain.Dog;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface DogRepository {
    void createDog(String name, String race, int age, String sex, String ownerFullName, int ownerPhoneNumber);

    void createSexTypes();

   Set<String> getAllSexTypes();

    Collection<Dog> getAllDogs();

    Optional<Dog> getDogByName(String name);

    void removeDog(Integer id);

    void build();

    void createDog(Dog dog);

    Dog getDogById(Integer id);

    void ownerHasPaid(int id);

    default void updateDog(int id, Dog dog) {
        throw new NotImplementedException();
    };

    void removeCageFromDog(Integer id);
}
