package com.zelgath.dogshotel.domain;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
public class Cage {
    private String description;
    private int price;
    private boolean occupied = false;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cage")
    private int id;
    private boolean free = true;


    public Cage(){
    }

    public Cage(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public Cage(int id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
            this.free = free;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Cage{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", occupied=" + occupied +
                ", id=" + id +
                ", free=" + free +
                '}';
    }
}
