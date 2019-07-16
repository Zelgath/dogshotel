package com.zelgath.dogshotel.domain;

import org.hibernate.engine.internal.Cascade;
import org.hibernate.validator.constraints.Range;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static java.time.LocalDate.parse;

@Entity
public class Dog {
    @NotNull
    @Size(min = 1, message = "Pole imię nie może być puste")
    private String name;

    @NotNull
    @Size(min = 1, message = "Pole rasa nie może być puste")
    private String race;

    @NotNull
    @Range(min = 0, max = 100, message = "Wiek psa musi być z zakresu 0-100")
    private int age;

    @OneToOne
    @JoinColumn(name = "id_cage")
    private Cage cage;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dog")
    private int id;


    private String sex;

    private int durationOfStayInDays;

    private LocalDate startOfStayDate;

    private LocalDate endOfStayDate;

    private String ownerFullName;

    private int ownerPhoneNumber;

    private int ownerCharge;


    public Dog(){

    }

    public Dog(String name, String race, int age, String sex, String ownerFullName, int ownerPhoneNumber) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.sex = sex;
        this.ownerFullName = ownerFullName;
        this.ownerPhoneNumber = ownerPhoneNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cage getCage() {
        return cage;
    }

    @Transactional
    public void setCage(Cage cage) {
        if(cage.isFree()) {
            this.cage = cage;
        }
    }

    public void setNullCage() {
        if (this.cage != null && this.cage.isOccupied()) {
            this.cage = null;
            this.startOfStayDate = null;
            this.endOfStayDate = null;
        }
    }

    public LocalDate getStartOfStayDate() {
        return startOfStayDate;
    }

    public void setStartOfStayDate(String startOfStayDate) {
        this.startOfStayDate = parse(startOfStayDate);
        setEndOfStayDate();
    }

    public LocalDate getEndOfStayDate() {
        return endOfStayDate;
    }

    public void setEndOfStayDate() {
        if(this.startOfStayDate != null && this.durationOfStayInDays != 0) {
            this.endOfStayDate = this.startOfStayDate.plusDays(durationOfStayInDays);
        }
    }

    public int getDurationOfStayInDays() {
        return durationOfStayInDays;
    }

    public void setDurationOfStayInDays(int durationOfStayInDays) {
        this.durationOfStayInDays = durationOfStayInDays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOwnerFullName() {
        return ownerFullName;
    }

    public void setOwnerFullName(String ownerFullName) {
        this.ownerFullName = ownerFullName;
    }

    public int getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(int ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public int getOwnerCharge() {
        return ownerCharge;
    }

    public void setOwnerCharge(int ownerCharge) {
        this.ownerCharge = ownerCharge;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", age=" + age +
                ", cage=" + cage +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", durationOfStayInDays=" + durationOfStayInDays +
                ", startOfStayDate=" + startOfStayDate +
                ", endOfStayDate=" + endOfStayDate +
                ", ownerFullName='" + ownerFullName + '\'' +
                ", ownerPhoneNumber=" + ownerPhoneNumber +
                ", ownerCharge=" + ownerCharge +
                '}';
    }

}

