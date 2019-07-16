package com.zelgath.dogshotel.domain.repositories;

import com.zelgath.dogshotel.domain.Cage;
import com.zelgath.dogshotel.domain.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DBDogRepository implements DogRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    CageRepository cageRepository;

    Set<String> sexTypes = new HashSet<>();

    @Override
    @Transactional
    public void createDog(Dog dog) {
        em.persist(dog);
    }

    @Override
    public Dog getDogById(Integer id) {
        return em.find(Dog.class, id);
    }

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

    @Override
    public Optional<Dog> getDogByName(String name) {
        System.out.println("Używam bazy danych");
        throw new NotImplementedException();
    }

    @Override
    @Transactional
    public void createDog(String name, String race, int age, String sex, String ownerFullName, int ownerPhoneNumber) {
        Dog newDog = new Dog(name, race, age, sex, ownerFullName, ownerPhoneNumber);
        em.persist(newDog);
    }

    @Override
    public Collection<Dog> getAllDogs() {
        return em.createQuery("from Dog", Dog.class).getResultList();
    }



    @Override
    @Transactional
    public void ownerHasPaid(int id) {
        getDogById(id).setOwnerCharge(0);
        em.merge(getDogById(id));
    }

    @Override
    @Transactional
    public void removeDog(Integer id) {
        Dog dog = getDogById(id);
        if (dog.getCage() != null && dog.getCage().isOccupied()) {
            dog.getCage().setOccupied(false);
            dog.getCage().setFree(true);
            dog.setNullCage();
        }
            em.remove(dog);

    }

    @Override
    @Transactional
    public void updateDog(int id, Dog dog) {
        dog.setOwnerCharge(dog.getDurationOfStayInDays()*dog.getCage().getPrice());
        em.merge(dog);
    }

    @Override
    @Transactional
    public void removeCageFromDog(Integer id) {
        Dog dog = getDogById(id);
        dog.setNullCage();
    }

    @Override
    public void build() {
        //method used in InMemoryRepo
    }
}
