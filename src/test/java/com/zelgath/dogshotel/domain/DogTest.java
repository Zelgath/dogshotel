package com.zelgath.dogshotel.domain;
import com.zelgath.dogshotel.utils.Ids;
import org.junit.Test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class DogTest {


//    @Test
//    public void testIfCageMarkedAsOccupied() {
//        Map<Integer, Cage> cages = new HashMap<>();
//        Dog dog = new Dog("Spike", "Border Collie", 4, "Wykastrowany Pies", "Testowy właściciel", 730);
//        Cage cage = new Cage(Ids.generateNewId(cages.keySet()), "Kojec testowy", 1);
//
//        dog.setCage(cage);
//
//        assertTrue(dog.getCage().isOccupied());
//        assertFalse(dog.getCage().isFree());
//    }
//
//    @Test
//    public void testIfDurationOfStayHasEndedAndCageFlagsSwitched() {
//        Dog dog = new Dog("Spike", "Border Collie", 4, "Wykastrowany Pies", "Testowy właściciel", 730);
//        Cage cage = new Cage(1, "Testowy kojec", 1);
//        int durationOfStay = 5;
//        dog.setDurationOfStayInDays(durationOfStay);
//        dog.setCage(cage);
//        LocalDate testEndDateOfStay = dog.getStartOfStayDate().plusDays(durationOfStay);
//
//        if (testEndDateOfStay.isEqual(dog.getEndOfStayDate())) {
//            dog.setNullCage();
//        }
//        assertTrue(cage.isFree());
//        assertFalse(cage.isOccupied());
//
//        assertNull(dog.getCage());
//    }
//
//    @Test
//    public void testIfStartAndEndDateAreWorking() {
//        Dog dog = new Dog("Spike", "Border Collie", 4, "Wykastrowany Pies", "Testowy właściciel", 730);
//        Cage cage = new Cage(1, "Testowy kojec", 1);
//        int durationOfStay = 5;
//        dog.setDurationOfStayInDays(durationOfStay);
//        dog.setCage(cage);
//        LocalDate endOfStayDate = dog.getStartOfStayDate().plusDays(dog.getDurationOfStayInDays());
//        assertEquals(dog.getEndOfStayDate(), endOfStayDate);
//    }
//
//    @Test
//    public void testIfOwnerChargeIsCountedCorrectly() {
//        Dog dog = new Dog("Spike", "Border Collie", 4, "Wykastrowany Pies", "Testowy właściciel", 730);
//        Cage cage = new Cage(1, "Testowy kojec", 1);
//        int durationOfStay = 5;
//        dog.setDurationOfStayInDays(durationOfStay);
//        dog.setCage(cage);
//
//        assertEquals(dog.getCage().getPrice()*dog.getDurationOfStayInDays(), durationOfStay*cage.getPrice());
//    }

}
