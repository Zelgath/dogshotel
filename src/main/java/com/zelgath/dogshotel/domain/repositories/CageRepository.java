package com.zelgath.dogshotel.domain.repositories;

import com.zelgath.dogshotel.domain.Cage;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

public interface CageRepository {

    List<Cage> getAllCages();
    void createHouseCages();
    void createBigCages();
    void createSmallCages();
    void createRoomCages();
    void resetCage(int id);


    void removeCage(Cage cage);

    void init();

    void update(Cage cage);

    Cage getCage(int id);
}
