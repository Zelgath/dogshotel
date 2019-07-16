package com.zelgath.dogshotel.domain.repositories;

import com.zelgath.dogshotel.domain.Cage;
import com.zelgath.dogshotel.domain.Dog;
import com.zelgath.dogshotel.utils.Ids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public class DBCageRepository implements CageRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    DogRepository dogRepository;

    @Override
    public void createBigCages() {

//            Method used for InMemoryRepo

    }

    @Override
    public void createSmallCages() {

//            Method used for InMemoryRepo

    }

    @Override
    public void createRoomCages() {

//            Method used for InMemoryRepo
    }

    @Override
    @Transactional
    public void createHouseCages() {

//            Method used for InMemoryRepo

    }


    @Override
    public List<Cage> getAllCages() {
        return em.createQuery("from Cage", Cage.class).getResultList();
    }

    @Override
    public void init() {
       // Method used for InMemoryRepo
    }

    @Scheduled(fixedDelayString  = "${cagesUpdateInterval}")
    @Transactional
    public void updateEndOfStays () {
        Collection<Dog> allDogs = dogRepository.getAllDogs();

        for (Dog dog:allDogs) {
            if (LocalDate.now().isAfter(dog.getEndOfStayDate())) {
                dog.getCage().setFree(true);
                dog.getCage().setOccupied(false);
                dog.setNullCage();

            }
        }
    }

    @Scheduled(fixedDelayString  = "${cagesUpdateInterval}")
    @Transactional
    public void updateStartOfStays() {
        Collection<Dog> allDogs = dogRepository.getAllDogs();

        for (Dog dog:allDogs) {
            if(LocalDate.now().isEqual(dog.getStartOfStayDate())) {
                dog.getCage().setOccupied(true);
                dog.getCage().setFree(false);
                update(dog.getCage());
            }
        }
    }

    @Override
    public void update(Cage cage) {
        em.merge(cage);
    }

    @Override
    public void removeCage(Cage cage) {
        em.remove(cage);
    }

    @Override
    public Cage getCage(int id) {
        return em.find(Cage.class, id);
    }

    @Override
    @Transactional
    public void resetCage(int id) {
        Cage cage = getCage(id);
        cage.setFree(true);
        cage.setOccupied(false);
    }
}
