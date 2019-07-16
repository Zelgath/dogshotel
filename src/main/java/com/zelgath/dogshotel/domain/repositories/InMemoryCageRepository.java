package com.zelgath.dogshotel.domain.repositories;

import com.zelgath.dogshotel.domain.Cage;
import com.zelgath.dogshotel.utils.Ids;


import javax.annotation.PostConstruct;
import java.util.*;


public class InMemoryCageRepository implements CageRepository {

    Map<Integer, Cage> cages = new HashMap<>();

    public InMemoryCageRepository() {
    }

    @Override
    public List<Cage> getAllCages() {
       return new ArrayList<>(cages.values());
    }

    @Override
    public void createBigCages(){
        for(int i = 1; i<8; i++) {
            int id = Ids.generateNewId(cages.keySet());
            Cage newBigCage = new Cage(id, "Duży kojec", 39);
            newBigCage.setDescription(newBigCage.getDescription() + " " + i);
            cages.put(newBigCage.getId(), newBigCage);
        }
    }

    @Override
    public void createSmallCages(){
        for(int i = 1; i<9; i++) {
            int id = Ids.generateNewId(cages.keySet());
            Cage newSmallCage = new Cage(id, "Mały kojec", 25);
            newSmallCage.setDescription(newSmallCage.getDescription() + " " + i);
            cages.put(newSmallCage.getId(), newSmallCage);
        }
    }

    @Override
    public void createRoomCages(){
        for(int i = 1; i<9; i++) {
            int id = Ids.generateNewId(cages.keySet());
            Cage newRoomCage = new Cage(id, "Pokój w budynku", 35);
            newRoomCage.setDescription(newRoomCage.getDescription() + " " + i);
            cages.put(newRoomCage.getId(), newRoomCage);
        }
    }

    @Override
    public void resetCage(int id) {
    }


    @Override
    public void createHouseCages(){
        for(int i = 1; i<4; i++) {
            int id = Ids.generateNewId(cages.keySet());
            Cage newHouseCage = new Cage(id, "Dom", 50);
            newHouseCage.setDescription(newHouseCage.getDescription() + " " + i);
            cages.put(newHouseCage.getId(), newHouseCage);
        }
    }

    @Override
    public void update(Cage cage) {
        cages.put(cage.getId(), cage);
    }

    @Override
    public void removeCage(Cage cage) {
        cages.remove(cage.getId());
    }

    @Override
    public Cage getCage(int id) {
       return cages.get(id);
    }

    @Override
    @PostConstruct
    public void init() {
        createBigCages();
        createHouseCages();
        createSmallCages();
        createRoomCages();
    }

    @Override
    public String toString() {
        return "InMemoryCageRepository{" +
                "cages=" + cages +
                '}';
    }
}
